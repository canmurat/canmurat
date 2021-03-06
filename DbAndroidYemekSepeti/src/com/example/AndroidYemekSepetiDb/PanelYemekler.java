package com.example.AndroidYemekSepetiDb;


import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.VeriTabani.VeriTabanıYiyecekler;

public class PanelYemekler extends Activity {

	private VeriTabanıYiyecekler veritabanı;
	private SimpleCursorAdapterClass adapter;
	private Cursor kelimeListesiCursor;
	// Kelimeleri tutacak olan Cursor nesnesi.
	
	// Database icindeki verileri ListView'e map ederken from ve to 'yu kullanıyoruz .
	private String[] from = new String[] {

	// Adapter'a eklenmek uzere from ve to Listeleri tanımlanıyor.
	// From'da nelerin eklenecegi bilgisi var.
	VeriTabanıYiyecekler.URUN_ADI, 
	VeriTabanıYiyecekler.URUN_FIYATI };

	// to icerisinde eklenecek itemlerin hangi TextView'e eklenecegi bilgisi var .
	private int[] to = new int[] { 
			R.id.AdListItemTextView,
			R.id.FiyatListItemTextView };

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.yemekler);
		
		// Ekrana acılısta goruntunun gelmesi icin onCreate metoduna yazıldı.
		ekranKontrolleriniOlustur();
	}

	private void ekranKontrolleriniOlustur() {

		// Veritabanı nesnesi , ilgili Class'dan olusturuluyor.
		veritabanı = new VeriTabanıYiyecekler(this);
		// butun urunler sorgulanıp sonucları tutuluyor.Bu nesne adapter'a ekleniyor.
		kelimeListesiCursor = butunUrunleriSorgula();
		adapter = new SimpleCursorAdapterClass(this, R.layout.listtextviews,
				kelimeListesiCursor, from, to, 0);

		final EditText AdEditText = (EditText) findViewById(R.id.YemeklerAdEditText);
		final EditText FiyatEditText = (EditText) findViewById(R.id.YemeklerFiyatEditText);

		// Urun ekleme isleminde kaydet butonuna basılacagı zaman gerceklesek olaylar. 
		
		Button kaydetButton = (Button) findViewById(R.id.kaydetBtnYemekler);
		kaydetButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Urun ekle butonuna basıldıgı zaman UrunEkle methodu gerceklestiriliyor.
				String ad = AdEditText.getText().toString();
				String fiyat = FiyatEditText.getText().toString();
				
				UrunEkle(ad, fiyat);
				
			}
		});

		Button guncelleButton = (Button) findViewById(R.id.gnclleBtnYemekler);
		guncelleButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String ad = AdEditText.getText().toString();
				String fiyat = FiyatEditText.getText().toString();
				// Urun Guncelle butonuna basıldıgında ad,fiyat bilgileriyle UrunGuncelle methodu gerceklestiriliyor.
				UrunGuncelle(ad, fiyat);
			}
		});

		Button silButton = (Button) findViewById(R.id.silBtnYemekler);
		silButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String ad = AdEditText.getText().toString();
				// Urun sil denildigi zaman ismi verilen ürün siliniyor. Her isim'den birtane kayıt ediliyordu
				UrunSil(ad);
			}
		});
		//ListView Olusturuldu ve adapter set edildi.
		ListView YemeklerListView = (ListView) findViewById(R.id.SiparislerListView);
		YemeklerListView.setAdapter(adapter);
		// YemeklerListesinde item secilmesi anında gerceklesecek olaylar burda yer almakta.
		YemeklerListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView arg0, View view, int position,
					long id) {
				//Adapter, secilmis olan pozisyona getiriliyor.
				adapter.setSelectedPosition(position);
				// Listede herhangi bir yemek secildigi zaman o yemekler EditText'lere aktarılıyor.
				editTextGuncelle(kelimeListesiCursor, position, AdEditText,
						FiyatEditText);
			}
		});

	}

	// yemek listesinde adı verilen yemegin Id degeri getiriliyor.
	private int getUrunId(String ad) {

		// Id degerini tutmak icin isime gore urun sorgulanıyor.Sonuc Cursor'da tutuluyor.
		Cursor cursor = UrunSorgula(ad);
		//Cursor bos ise -1 dondur.
		if (cursor == null)
			return -1;
		// secilmis item sayısı sadece 1 olmalı. Onun kontrolu yapılıyor.
		int count = cursor.getCount();

		if (count != 1)
			return -1;
		
		// cursor ilk basta satır'ın ilk elemanını degil, 1 geriyi tutuyor.Ilk elemana gelmesi saglanıyor.
		cursor.moveToNext();
		// Urun adının bulundugu satırda, Urun_Id degerinin bulundugu sutundaki deger degiskene atılıyor
		int idIndex = cursor.getColumnIndex(VeriTabanıYiyecekler.URUN_ID);

		// Id degeri return edliyor.
		return cursor.getInt(idIndex);

	}

	private Cursor UrunSorgula(String ad) {

		if (ad == null)
			throw new RuntimeException(
					"Kelime adı sorgulama işlemi için boş bırakılamaz");


		String[] whereArgs = new String[] { ad };

		SQLiteDatabase db = veritabanı.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from yiyecekler where yiyecekler.Ad=?",whereArgs);
//		VeriTabanıYiyecekler.TABLE_NAME, projection,
//		where, whereArgs, null, null, null
		return cursor;

	}

	private long UrunEkle(String Ad, String Fiyat) {

		// Urun Id degeri getUrunId methodu ile alındı.Bunun icin id'si alınacak yemegin adı verildi.
		int UrunId = getUrunId(Ad);

		// getUrunId methoduyla Ismı verilen yemekte bir urun bulundu ise daha once eklenmistir deniliyor.
		// ve Cıkılıyor..
		if (UrunId != -1) {
			Toast.makeText(getApplicationContext(),
					"Bu kelime daha önce eklenmiştir", Toast.LENGTH_LONG)
					.show();
			return -1;
		}
		// Urun olmaması durumunda verilen Ad ve Soyad degerlerine gore Db'ye ekleme yapılıyor.
		// Bunun icin ContentValues sınıfı kullanılıyor.

		ContentValues satir = new ContentValues();
		satir.put("Ad", Ad);
		satir.put("Fiyat", Fiyat);
		
		// Daha once olusturulmus ilgili veritabanı referansından bir database nesnesi olusturuluyor.
		// Ve Ekleme islemleri bu nesne uzerinden yapılıyor.
		SQLiteDatabase db = veritabanı.getWritableDatabase();
		// Veritabanına urun eklendigi zaman (basarilı ise eklenen satir'in Id'si donuyor.)
		long eklenenKelimeId = db.insert(VeriTabanıYiyecekler.TABLE_NAME, null,
				satir);
		//Yeni bir urun eklendigi icin Liste guncelleniyor.
		listeGuncelle();
		// Yiyecegin eklendigi mesaji bildiriliyor.
		Toast.makeText(this, "Yiyecek Eklenmistir", Toast.LENGTH_SHORT).show();
		return eklenenKelimeId;

	}
	// Urun,verilen Ad ve Fiyat bilgilerine guncelleniyor.Icra eden yordam. 
	private void UrunGuncelle(String Ad, String Fiyat) {

		ContentValues guncelSatir = new ContentValues();
		guncelSatir.put("Ad", Ad);
		guncelSatir.put("Fiyat", Fiyat);

		int kelimeId = getUrunId(Ad);
		// Veritabanından verilen isme gore bir Id degeri elde edilemiyor ise guncellenecek kelime bulunamadı deniyor.
	
		if (kelimeId == -1) {
			Toast.makeText(getApplicationContext(),
					"Güncellenecek kelime bulunamadı", Toast.LENGTH_LONG)
					.show();
			return;
		}
		// Urun'un yeni bilgileri getUrunId'si ile alınmıstı ve o degere gore guncelleme gerceklestirilyor.
		SQLiteDatabase db = veritabanı.getWritableDatabase();
		// Hangi tablo'nun , hangi satırın ne olarak guncellenecegi bilgilerini veriyoruz.
		String where = VeriTabanıYiyecekler.URUN_ID + "=" + kelimeId;
		db.update(VeriTabanıYiyecekler.TABLE_NAME, guncelSatir, where, null);
		//Urun guncellemesi oldugu icin Listede Guncelleniyor.
		listeGuncelle();
	}
	// Listedeki bir urun'u silecegimiz zaman Id degerini tutuyoruz.
	private void UrunSil(String ad) {

		int kelimeId = getUrunId(ad);
		// verilen isim degerinde bir yemek bulunamadı ise mesaj donduruluyor.
		if (kelimeId == -1) {
			Toast.makeText(getApplicationContext(),
					"Silinecek yemek bulunamadı", Toast.LENGTH_LONG).show();
			return;
		}
		// Alınan Id degerine gore Veritabanında silme islemi gerceklestirilyor.
		SQLiteDatabase db = veritabanı.getWritableDatabase();
		String where = VeriTabanıYiyecekler.URUN_ID + "=" + kelimeId;
		db.delete(VeriTabanıYiyecekler.TABLE_NAME, where, null);
		listeGuncelle();

	}

	// ListView'de seçim yapıldığı zaman EditText'lere yapılan seçimler ekleniyor. 
	private void editTextGuncelle(Cursor cursor, int position,
			EditText AdEditText, EditText FiyatEditText) {
		// cursor nesnesine secilmis olan position getiriliyor.
		cursor.moveToPosition(position);
		/* cursor nesnesinde secilmis satır'a gelindi. O satırdaki Ad degerinin Column index'i tutuluyor
		 * ve Fiyat degerinin column index'i tutuluyor. */
		int adIndex = cursor.getColumnIndex(VeriTabanıYiyecekler.URUN_ADI);
		int FiyatIndex = cursor
				.getColumnIndex(VeriTabanıYiyecekler.URUN_FIYATI);
		// Ad ve Fiyat degerleri ilgili nesneden cekiliyor.
		String Ad = cursor.getString(adIndex);
		String Fiyat = cursor.getString(FiyatIndex);
		// EditText'e secilmis olan bilgilerin getirilmesi saglanıyor.
		AdEditText.setText(Ad);
		FiyatEditText.setText(Fiyat);

	}
	// Listesi guncelle diyerek adapter'ın yenilenmesi saglanıyor.
	private void listeGuncelle() {
		
		kelimeListesiCursor.requery();
		adapter.notifyDataSetChanged();

	}
	// Lısteyi ilk dolduracagımız zaman tum urunler sorgulanıyor ve donen cursor nesnesi adapter'a ekleniyor.
	private Cursor butunUrunleriSorgula() {
		
		SQLiteDatabase db = veritabanı.getReadableDatabase();
		return db.rawQuery("select Id as _id, Ad, Fiyat from yiyecekler", new String[] {});
		
//		VeriTabanıYiyecekler.TABLE_NAME, projection, null,
//		null, null, null, null
//		
	


	}

}

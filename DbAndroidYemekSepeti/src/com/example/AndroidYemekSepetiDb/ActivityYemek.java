package com.example.AndroidYemekSepetiDb;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.VeriTabani.VeriTabanıYiyecekler;

@SuppressLint("NewApi")
public class ActivityYemek extends Activity {

	Spinner spinneryemek;
	Button btnyemeksiparis;
	Button btnyemeksepet;
	TextView adettextyemek;
	EditText edittextyemek;

	List<CharSequence> YemeklerTumListe;

	public static String secilenYemek;
	public static int secilenYemekFiyati;
	public static int secilenYemekAdeti;

	int butonDegeri;

	// yemekler listesini tutan CharSequence Listesi
	final List<CharSequence> yemeklerListesi = new ArrayList<CharSequence>();

	final List<Integer> yemekFiyatlarıListesi = new ArrayList<Integer>();

	VeriTabanıYiyecekler veritabanı;
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yemek);

		
		veritabanı = new VeriTabanıYiyecekler(this);
		
		// Spinnerda goruntulenecek olan Listeler
		YemeklerTumListe = new ArrayList<CharSequence>();
		
		SQLiteDatabase db = veritabanı.getReadableDatabase(); 
		int sayac=0;
		// Veritabanının Yemekler tablosundaki tüm veriler Spinner'a eklenmek uzere Listeye atılıyor.
		Cursor cur = db.rawQuery("SELECT * FROM " + VeriTabanıYiyecekler.TABLE_NAME, null);
		if (cur != null) {
		    if (cur.moveToFirst()) {
		        do {
		        	String yemeginAdi = cur.getString(cur.getColumnIndex("Ad"));
		        	int yemeginFiyatı = cur.getInt(cur.getColumnIndex("Fiyat"));
		        	yemeklerListesi.add(sayac,yemeginAdi);
		        	YemeklerTumListe.add(yemeginAdi + " " +yemeginFiyatı+ " TL");
		        	yemekFiyatlarıListesi.add(yemeginFiyatı);
		        	sayac++;
		        } while (cur.moveToNext());
		    }
		}

		sayac=0;
		//tanımlamalar..
		spinneryemek = (Spinner) findViewById(R.id.spinneryemek);
		btnyemeksiparis = (Button) findViewById(R.id.btnyemeksiparis);
		btnyemeksepet = (Button) findViewById(R.id.btnyemeksepet);
		adettextyemek = (TextView) findViewById(R.id.adettextyemek);
		edittextyemek = (EditText) findViewById(R.id.edittextyemek);

		//YemeklerTumListe , ArrayAdapter'a ekleniyor.
		ArrayAdapter<CharSequence> adapter1 = new ArrayAdapter<CharSequence>(
				this, android.R.layout.simple_dropdown_item_1line,
				YemeklerTumListe);
		spinneryemek.setAdapter(adapter1);

		//yemek siparis onclick olayı.
		btnyemeksiparis.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				butonDegeri = 1;
				//Edit text'ten adet olarak deger girilmemis ise 1 al.
				if (edittextyemek.getText().toString() == null
						|| edittextyemek.getText().toString().trim().equals("")
						|| edittextyemek.getText().toString().trim().isEmpty()) {
					Toast toast = Toast.makeText(ActivityYemek.this,
							"Adet miktarı en az 1 dir !", Toast.LENGTH_SHORT);
					toast.show();
					secilenYemekAdeti = 1;

				} else if (edittextyemek.getText().toString() == "0") {
					secilenYemekAdeti = 1;
					Toast toast = Toast.makeText(ActivityYemek.this,
							"Adet miktarı en az 1 dir !", Toast.LENGTH_SHORT);
					toast.show();
					//eger deger girilmis ise , ne girildiyse onu al.
				} else {
					String no = edittextyemek.getText().toString();
					secilenYemekAdeti = Integer.parseInt(no);
				}

				//secilen yemegin' index'ini spinner'dan alıyorm ve aynı index degerinden fiyatına  erisiyorm
				int yemekIndex = spinneryemek.getSelectedItemPosition();
				secilenYemek = (String) yemeklerListesi.get(yemekIndex);
				secilenYemekFiyati = yemekFiyatlarıListesi.get(yemekIndex);

				Intent intent = new Intent(ActivityYemek.this, SiparisVer.class);

				Bundle newActivityInfo = new Bundle();
				
				//Secilen degerler Diger intent'e aktarılmak icin BUndle'a atıldı.
				
				newActivityInfo.putString("secilenYemek", secilenYemek);
				newActivityInfo
						.putInt("secilenYemekFiyati", secilenYemekFiyati);
				newActivityInfo.putInt("secilenYemekAdeti", secilenYemekAdeti);
				newActivityInfo.putInt("butonDegeri", butonDegeri);
				Toast toast = Toast
						.makeText(ActivityYemek.this,
								"Seçilen Yemekler Sepete eklendi !",
								Toast.LENGTH_SHORT);
				//Secilen yemekler sepete atılınca Toast dondu.
				intent.putExtras(newActivityInfo);

				startActivity(intent);
				toast.show();

			}
		});

	}
// Yemek sepetine gitmesi icin yemek sepeti intent'i baslatılıyor.
	public void yemekSepeti(View v) {
		Intent intent = new Intent(ActivityYemek.this, SiparisVer.class);
		startActivity(intent);

	}
	public void btnCikis(View v)
	{
		Intent intent = new Intent(ActivityYemek.this, KullaniciGiris.class);
		startActivity(intent);
	}

}

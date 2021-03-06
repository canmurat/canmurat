package com.example.AndroidYemekSepetiDb;

import java.util.Locale;

import com.example.VeriTabani.VeriTabanıKisiler;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class KullaniciGiris extends Activity {

	private String[] projection = new String[] { VeriTabanıKisiler.KISI_ID,
			VeriTabanıKisiler.KISI_ADI, VeriTabanıKisiler.KISI_SIFRE, };

	EditText editEmail;
	EditText editSifre;
	String Email;
	String Sifre;
	
	public static int KullaniciId;

	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kullanicigiris);

		VeriTabanıKisiler vs = new VeriTabanıKisiler(this);
		
		SQLiteDatabase db = vs.getWritableDatabase();
		
		
		editEmail = (EditText) findViewById(R.id.editEmailGiris);
		editSifre = (EditText) findViewById(R.id.editSifre);
		

	}

	public void GirisYap(View v) {
		Intent intent1 = new Intent(KullaniciGiris.this, MainClass.class);
		Intent intent2 = new Intent(KullaniciGiris.this, YoneticiPanel.class);

		if (!Adminmi() && KullaniciVarmi()) {
			startActivity(intent1);
		}
		else if (Adminmi() && KullaniciVarmi()) {
			startActivity(intent2);

		} 
		else {
			Toast.makeText(this, "kullanici Bulunamadı", Toast.LENGTH_LONG).show();
		}
	}

	public void UyeOl(View v) {
		Intent intent = new Intent(KullaniciGiris.this, UyeOl.class);
		startActivity(intent);

	}

	public boolean KullaniciVarmi() {

		Email = editEmail.getText().toString();
		Sifre = editSifre.getText().toString();

		Cursor cursor = KullaniciSorgula(Email, Sifre);
		
		Boolean hasTables = cursor.moveToFirst();
		return hasTables;
	}

	public boolean Adminmi() {

		Email = editEmail.getText().toString();
		Sifre = editSifre.getText().toString();

		boolean adminmi = false;
		Cursor cursor = KullaniciSorgula(Email, Sifre);

		if (cursor == null)
			return false;

		int count = cursor.getCount();

		if (count != 1)
			return false;

		cursor.moveToNext();

		int kullaniciIdIndex = cursor.getColumnIndex(VeriTabanıKisiler.KISI_ID);
		int AdminColumnIndex = cursor.getColumnIndex(VeriTabanıKisiler.KISI_ADMINMI);
		int deger = cursor.getInt(AdminColumnIndex);
		KullaniciId = cursor.getInt(kullaniciIdIndex);
		Log.i("deger", String.valueOf(deger));
		Log.i("Email=", Email);
		Log.i("Sifre=", Sifre);
		Log.i("BoolAdmin=", String.valueOf(AdminColumnIndex));
		Log.i("deger=", String.valueOf(deger));

		if (deger == 1) {
			adminmi = true;
		}
		return adminmi;
	}

	public Cursor KullaniciSorgula(String kulAd, String sifre) {
		VeriTabanıKisiler veritabanı = new VeriTabanıKisiler(this);

		if (kulAd == null || sifre == null)
			throw new RuntimeException(
					"kullanici adı veya sifre sorgulama işlemi için boş bırakılamaz");

		String where = VeriTabanıKisiler.KISI_ADI + "=? and "
				+ VeriTabanıKisiler.KISI_SIFRE + "=?";
		String[] whereArgs = new String[] { kulAd.trim(), sifre.trim() };

		SQLiteDatabase db = veritabanı.getReadableDatabase();

		// VeriTabanıKisiler.TABLE_NAME, projection,
		// where, whereArgs, null, null, null
		Cursor cursor = db
				.rawQuery("select * from kullanicilar where Ad=? and Sifre=?;",
						whereArgs);

		int kullaniciColumnIndex = cursor.getColumnIndex(VeriTabanıKisiler.KISI_ADI);
		
		System.out.println("kullaniciColumnIndex = " + kullaniciColumnIndex);
		System.out.println("cursor count = " + cursor.getColumnCount());
	
		// Kullanici'nin Id degerini siparis tablosuna ekleyebilmek icin public degiskene atıyorum.
	
		return cursor;
	}
}

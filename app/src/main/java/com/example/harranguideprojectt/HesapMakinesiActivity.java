package com.example.harranguideprojectt;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HesapMakinesiActivity extends AppCompatActivity {

    private EditText editTxtBirinciSayi, editTxtIkinciSayi; /*kullanıcıdan alınan sayılar */
    private TextView txtSonuc;
    private String birinciSayi, ikinciSayi;
    private int s1, s2, sonuc;
    private Hesapla hesapla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesapmakinesi);
        editTxtBirinciSayi = (EditText)findViewById(R.id.editTxtBirinciSayi);
        editTxtIkinciSayi = (EditText)findViewById(R.id.editTxtIkinciSayi);
        txtSonuc = (TextView)findViewById(R.id.textViewSonuc);

    }


    public void btnHesapla(View v) {
        birinciSayi = editTxtBirinciSayi.getText().toString();
        ikinciSayi = editTxtIkinciSayi.getText().toString();
        hesapla = new Hesapla(s1, s2);


        if (!TextUtils.isEmpty(birinciSayi) && !TextUtils.isEmpty(ikinciSayi)) { /* sayılar boş değilse bunun içine gir. */
            s1 = Integer.valueOf(birinciSayi);
            s2 = Integer.valueOf(ikinciSayi);

            switch (v.getId()) { //fonskiyon secimi
                case R.id.btnTopla:
                    sonuc = hesapla.toplam();
                    break;

                case R.id.btnFark:
                    sonuc = hesapla.fark();
                    break;
                case R.id.btnCarp:
                    sonuc = hesapla.carpim();
                    break;
                case R.id.btnBolme:
                    sonuc = hesapla.bolum();
                    break;

            }
            txtSonuc.setText("Sonuc: " + sonuc);
        } else
            txtSonuc.setText("Girilen değerler boş olamaz.");
    }
}




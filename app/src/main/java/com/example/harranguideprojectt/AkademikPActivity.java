package com.example.harranguideprojectt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AkademikPActivity extends AppCompatActivity {


    private ImageView ak1,ak2,ak3,ak4,ak5,ak6;
    private Button ButtonAkademisyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akademikp);
        //Image lerin tanımlaması yapılır.
        ImageView ak1 = (ImageView) findViewById(R.id.ak1);
        ImageView ak2 =(ImageView) findViewById(R.id.ak2);
        ImageView ak3 = (ImageView) findViewById(R.id.ak3);
        ImageView ak4 =(ImageView) findViewById(R.id.ak4);
        ImageView ak5 = (ImageView) findViewById(R.id.ak5);
        ImageView ak6 =(ImageView) findViewById(R.id.ak6);
        Button ButtonAkademisyen = (Button) findViewById(R.id.ButtonAkademisyen);

        // butona tıklandığında yapılması gereken islem tanımlanır
        ButtonAkademisyen.setOnClickListener(v -> {

            gotoUrl("http://web.harran.edu.tr/muhendis/tr/personel/akademik-personel/");
        });






    }

    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent((Intent.ACTION_VIEW),uri));
    }
}

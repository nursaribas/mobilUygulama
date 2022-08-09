package com.example.harranguideprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    public Button giris;
    public Button kayıtOl;
    private EditText email;
    private  EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        giris = (Button) findViewById(R.id.giris);
        kayıtOl= (Button) findViewById(R.id.kayıtOl);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


        kayıtOl.setOnClickListener(new View.OnClickListener() { //kayıt butonuna tıklandığında yönlendirilecek kısım
            @Override
            public void onClick(View view) {
                Intent kaydolIntent= new Intent(MainActivity.this,Register.class);
                startActivity(kaydolIntent);
            }
        });




        
        //sayfalar arasındaki geçişin olacağı kısım
        giris.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);


            }
        });
    }}












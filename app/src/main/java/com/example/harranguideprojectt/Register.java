package com.example.harranguideprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Register extends AppCompatActivity {

    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    private TextView logo,logo2;
    private TextView email, password,name,password2;
    private Button kayıtOl;
    private Toolbar ActionRegister;

    private FirebaseAuth auth;


    public void init(){


        auth = FirebaseAuth.getInstance();


        EditText Remail = (EditText) findViewById(R.id.email);
        EditText Rname = (EditText) findViewById(R.id.name);
        EditText Rpassword= (EditText) findViewById(R.id.password);
        EditText Rpassword2= (EditText) findViewById(R.id.password2);
        Button kayıtOl = (Button) findViewById(R.id.kayıtOl);
        kayıtOl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

                createNewAccount();

            }

        });

    }

    private void setSupportActionBar(Toolbar actionRegister) {
    }


    private void createNewAccount() { //kullanıcı kayıt sırasında yapılacak islemlerin sırası ve kontroller
        String Rname = name.getText().toString();
        String Remail = email.getText().toString();
        String Rpassword = password.getText().toString();
        String Rpassword2 = password2.getText().toString();
        if(TextUtils.isEmpty(Remail)) {
            Toast.makeText(this,"email alanı boş bırakılamaz ",Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(Rpassword)) {
            Toast.makeText(this,"sifre alanı bos bırakılmaz",Toast.LENGTH_LONG).show();

        } else if (TextUtils.isEmpty(Rpassword2)){
            Toast.makeText(this,"sifre alanı aynı değil",Toast.LENGTH_LONG).show();

        } else {
            auth.createUserWithEmailAndPassword(Remail,Rpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Register.this,"email alanı boş geçilemez",Toast.LENGTH_LONG).show();
                        Intent mainIntent= new Intent(Register.this,Login.class);
                        startActivity(mainIntent);
                        finish();

                    } else {
                        Toast.makeText(Register.this,"hata olustu", Toast.LENGTH_LONG).show();


                    }


                }

            });
        }


    }


    protected void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);
        init();

    }







}
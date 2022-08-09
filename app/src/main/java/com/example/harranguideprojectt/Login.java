package com.example.harranguideprojectt;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Login extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private EditText email;
    private EditText password;
    public Button giris;
    public Button kayıtOl;
    private Object Task;
    private Object mBinding;
    FirebaseUser firebaseUser;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");



        mAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        giris = (Button) findViewById(R.id.giris);
        kayıtOl= (Button) findViewById(R.id.kayıtOl);

        if(firebaseUser != null) { //kullanıcın kayıtlı olması durumunda yönlendirileceği sınıf

            Intent intent = new Intent(Login.this, MenuActivity.class);
            startActivity(intent);
            finish();
        }




        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        kayıtOl.setOnClickListener(new View.OnClickListener() { //kayıt butonuna tıklandığında yönlendirilecek kısım
            @Override
            public void onClick(View v) { // yonlendirme
                Intent kaydolIntent= new Intent(Login.this,Register.class);
                startActivity(kaydolIntent);
            }
        });





        //sayfalar arasındaki geçişin olacağı kısım
        giris.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String txt_email=email.getText().toString();
                String txt_pass=email.getText().toString();
                if(TextUtils.isEmpty(txt_email)|| TextUtils.isEmpty(txt_pass)){
                    Toast.makeText(Login.this,"tekrar deneyiniz", Toast.LENGTH_SHORT).show();
                }else {
                    mAuth.signInWithEmailAndPassword(txt_email,txt_pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Intent intent = new Intent(Login.this,MenuActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    } else { Toast.makeText(Login.this, "olmadi", Toast.LENGTH_SHORT).show(); }
                                }
                            });
                }


            }

        });


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }



    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }


                        FirebaseAuth.getInstance().signOut();


                    }
                });
    }

    private void updateUI(FirebaseUser user) {
    }




}
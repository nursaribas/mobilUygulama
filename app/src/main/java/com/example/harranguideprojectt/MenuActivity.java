package com.example.harranguideprojectt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    private Object view;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public boolean onCreateOptionsMenu (Menu menu){ //itemlerin gosterilmesi icin yapılan bağlantı

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_design, menu);

        super.onCreateOptionsMenu(menu);

        return true;

    }

    public boolean onOptionsItemSelected (MenuItem item) { //menu de tıklandıgında yönlendirilecek url ve uygulamalar

        switch (item.getItemId()) {
            case R.id.oyun:
                startActivity(new Intent(this, GameActivity.class));
                return true;
            case R.id.obs_giris:
                gotoUrl("https://obs.harran.edu.tr/");
                return true;
            case R.id.akademikPersonel:
                startActivity(new Intent(this, AkademikPActivity.class));
               return true;
            case R.id.mezun_ogrenci:
                gotoUrl("https://mezunportali.harran.edu.tr/");
                return true;
            case R.id.muhendislik:
                gotoUrl("http://web.harran.edu.tr/muhendis/");
                return true;
            case R.id.egitim:
                gotoUrl("http://egitim.harran.edu.tr/");
                return true;
            case R.id.tıp:
                gotoUrl("http://tip.harran.edu.tr/");
                return true;
            case R.id.ilahiyat:
                gotoUrl("http://ilahiyat.harran.edu.tr/");
                return true;
            case R.id.yemekhane:
                gotoUrl("https://www.harran.edu.tr/yemeklist.aspx");
                return true;
            case R.id.harita:
                startActivity(new Intent(this, GoogleMapsSearch.class));
                return true;
                case R.id.duyuru:
                    gotoUrl("https://www.harran.edu.tr/duylist.aspx?duyPerSay=20&sayfaNum=0");
                return true;
            case  R.id.hesapMakinesi:
                startActivity(new Intent(this, HesapMakinesiActivity.class));
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent((Intent.ACTION_VIEW),uri));


    }
}

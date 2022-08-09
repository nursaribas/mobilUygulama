package com.example.harranguideprojectt;

import androidx.appcompat.app.AppCompatActivity;

public class Hesapla extends AppCompatActivity {

    private int gelenSayi1, gelenSayi2;

    public Hesapla(int gelenSayi1, int getGelenSayi2) {
        //yapılacak fonksiyonlar
        this.gelenSayi1 = gelenSayi1;
        this.gelenSayi2 = getGelenSayi2;
    }
    public int toplam(){

        return gelenSayi1 + gelenSayi2;
    }

    public  int fark(){
        return gelenSayi1 - gelenSayi2;
    }
    public int bolum(){
        return gelenSayi1 / gelenSayi2;

    }
    public int carpim(){
        return gelenSayi1 * gelenSayi2;
    }


}

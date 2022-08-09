package com.example.harranguideprojectt;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void BuClick(View view) {
        Button buSelected = (Button) view;
        int CellID = 0;
        switch ((buSelected.getId())) {

            case R.id.bu1:
                CellID = 1;
                break;

            case R.id.bu2:
                CellID = 2;
                break;

            case R.id.bu3:
                CellID = 3;
                break;

            case R.id.bu4:
                CellID = 4;
                break;

            case R.id.bu5:
                CellID = 5;
                break;

            case R.id.bu6:
                CellID = 6;
                break;

            case R.id.bu7:
                CellID = 7;
                break;

            case R.id.bu8:
                CellID = 8;
                break;

            case R.id.bu9:
                CellID = 9;
                break;


        }
        PlayGame(CellID, buSelected);
    }
    int ActivePlayer = 1; // 1 için ilk , 2 için ikinci
    ArrayList<Integer> Player1 = new ArrayList<Integer>();
    ArrayList<Integer> Player2 = new ArrayList<Integer>();


    void PlayGame(int CellId, Button buSelected){

        Log.d("Player: ",String.valueOf(CellId));
        //tuslara göre kontrollerin yapıldığı kısım

        if (ActivePlayer==1){
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.GREEN);
            Player1.add(CellId);
            ActivePlayer = 2;

            AutoPlay();

        }
        else if (ActivePlayer==2){
            buSelected.setText("O");
            buSelected.setBackgroundColor(Color.BLUE);
            Player2.add(CellId);
            ActivePlayer = 1;

        }
        buSelected.setEnabled(false);
        CheckWiner();

    }
    void CheckWiner(){
        int Winer = -1;

        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            Winer=1;
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            Winer=2;
        }
        // row 2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            Winer=1;
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            Winer=2;
        }
        // row 3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            Winer=1;
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            Winer=2;
        }
        // colon 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            Winer=1;
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            Winer=2;
        }
        // colon 2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            Winer=1;
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            Winer=2;
        }
        // colon 3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            Winer=1;
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            Winer=2;
        }

        if ( Winer !=-1){

            if (Winer==1){
                Toast.makeText(this,"1.Oyuncu kazandı.",Toast.LENGTH_LONG).show();
            }
            if (Winer==2){
                Toast.makeText(this,"2.Oyuncu kazandı",Toast.LENGTH_LONG).show();
            }
        }


    }

    void AutoPlay(){


        ArrayList<Integer> EmptyCells = new ArrayList<Integer>();

        for (int cellID=1; cellID<10; cellID++){
            if (!( Player1.contains(cellID) || Player2.contains(cellID))){
                EmptyCells.add(cellID);

            }
        }
        Random r = new  Random();
        int RandIndex = r.nextInt(EmptyCells.size()-0)+0;
        int CellID = EmptyCells.get(RandIndex);
        Button buSelected;
        switch (CellID) {

            case 1:
                buSelected = (Button) findViewById(R.id.bu1);
                break;

            case 2:
                buSelected = (Button) findViewById(R.id.bu2);
                break;

            case 3:
                buSelected = (Button) findViewById(R.id.bu3);
                break;

            case 4:
                buSelected = (Button) findViewById(R.id.bu4);
                break;

            case 5:
                buSelected = (Button) findViewById(R.id.bu5);
                break;

            case 6:
                buSelected = (Button) findViewById(R.id.bu6);
                break;

            case 7:
                buSelected = (Button) findViewById(R.id.bu7);
                break;

            case 8:
                buSelected = (Button) findViewById(R.id.bu8);
                break;

            case 9:
                buSelected = (Button) findViewById(R.id.bu9);
                break;
            default:
                buSelected = (Button) findViewById(R.id.bu1);
                break;


        }
        PlayGame(CellID, buSelected);




    }
}



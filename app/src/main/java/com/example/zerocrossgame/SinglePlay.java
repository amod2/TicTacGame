package com.example.zerocrossgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class SinglePlay extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,scoreV;
    int count=0;
    int player,computer_play;
    String winner;
    String louser;
    Dialog dialog;
    ArrayList<Integer> occupied_space;
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_play);
        occupied_space=new ArrayList<Integer>();
        random=new Random();
        t1=findViewById(R.id.text3);
        t2=findViewById(R.id.text4);
        t3=findViewById(R.id.text5);
        t4=findViewById(R.id.text6);
        t5=findViewById(R.id.text7);
        t6=findViewById(R.id.text8);
        t7=findViewById(R.id.text9);
        t8=findViewById(R.id.text10);
        t9=findViewById(R.id.text11);
        scoreV=findViewById(R.id.score);
        displayResult();
        dialog=new Dialog(this);

    }
    public void displayResult(){
        Intent intent=getIntent();
        try {
            computer_play=Integer.parseInt(intent.getStringExtra("computer"));
            player=Integer.parseInt(intent.getStringExtra("player"));
        }catch (Exception e){
            computer_play=0;
            player=0;
        }
        scoreV.setText(""+computer_play+"/"+player);
    }
    public void clickStart(int click_value ){
//        Log.i("akm", "clickStart: "+getVacantLine(1));
        if(getVacantLine(1) !=0){
            switch (getVacantLine(1)){
                case 1:
                    t1.setText("O");
                    t1.setOnClickListener(null);
                    break;
                case 2:
                    t2.setText("O");
                    t2.setOnClickListener(null);
                    break;
                case 3:
                    t3.setText("O");
                    t3.setOnClickListener(null);
                    break;
            }
        }else if(getVacantLine(2) !=0){
            switch (getVacantLine(2)){
                case 4:
                    t4.setText("O");
                    t4.setOnClickListener(null);
                    break;
                case 5:
                    t5.setText("O");
                    t5.setOnClickListener(null);
                    break;
                case 6:
                    t6.setText("O");
                    t6.setOnClickListener(null);
                    break;
            }
        }else if(getVacantLine(3) !=0){
            switch (getVacantLine(3)){
                case 7:
                    t7.setText("O");
                    t7.setOnClickListener(null);
                    break;
                case 8:
                    t8.setText("O");
                    t8.setOnClickListener(null);
                    break;
                case 9:
                    t9.setText("O");
                    t9.setOnClickListener(null);
                    break;
            }
        }
        count++;
        gameStatus();

    }
    public int getVacantLine(int i){

           if(i==1){
               if(t1.getText().toString().equals("")){
                   return 1;
               }else if(t2.getText().toString().equals("")){
                   return 2;
               }else if(t3.getText().toString().equals("")){
                   return 3;
               }
           }else if(i==2) {
               if (t4.getText().toString().equals("")) {
                   return 4;
               } else if (t5.getText().toString().equals("")) {
                   return 5;
               } else if (t6.getText().toString().equals("")) {
                   return 6;
               }
           }else  if(i==3){
                if(t7.getText().toString().equals("")){
                    return 7;
                }else if(t8.getText().toString().equals("")){
                    return 8;
                }else if(t9.getText().toString().equals("")){
                    return 9;
                }
            }

         return 0;
    }
    public void click1(View view) {
        int click_value=1;
        t1.setText("X");
        occupied_space.add(1);
        clickStart(click_value);
        TextView tv=findViewById(R.id.text3);
        tv.setOnClickListener(null);
    }

    private void gameStatus() {
        if (t1.getText().toString().equals(t2.getText().toString()) && t2.getText().toString().equals(t3.getText().toString()) && (t3.getText().toString().equals("X") || t3.getText().toString().equals("O"))) {
            winner=t1.getText().toString();
            if(winner.equals("X")){
                player++;
            }else {
                computer_play++;
            }
            displayBox();
        } else if (t4.getText().toString().equals(t5.getText().toString()) && t5.getText().toString().equals(t6.getText().toString()) && (t6.getText().toString().equals("X") || t6.getText().toString().equals("O"))) {
            winner=t4.getText().toString();
            if(winner.equals("X")){
                player++;
            }else {
                computer_play++;
            }
            displayBox();
        } else if (t7.getText().toString().equals(t8.getText().toString()) && t8.getText().toString().equals(t9.getText().toString()) && (t9.getText().toString().equals("X") || t9.getText().toString().equals("O"))) {
            winner=t7.getText().toString();
            if(winner.equals("X")){
                player++;
            }else {
                computer_play++;
            }
            displayBox();
        } else if (t1.getText().toString().equals(t4.getText().toString()) && t4.getText().toString().equals(t7.getText().toString()) && (t7.getText().toString().equals("X") || t7.getText().toString().equals("O"))) {
            winner=t8.getText().toString();
            if(winner.equals("X")){
                player++;
            }else {
                computer_play++;
            }
            displayBox();
        } else if (t2.getText().toString().equals(t5.getText().toString()) && t5.getText().toString().equals(t8.getText().toString()) && (t8.getText().toString().equals("X") || t8.getText().toString().equals("O"))) {
            winner=t2.getText().toString();
            if(winner.equals("X")){
                player++;
            }else {
                computer_play++;
            }
            displayBox();
        } else if (t3.getText().toString().equals(t6.getText().toString()) && t6.getText().toString().equals(t9.getText().toString()) && (t9.getText().toString().equals("X") || t9.getText().toString().equals("O"))) {
            winner=t3.getText().toString();
            if(winner.equals("X")){
                player++;
            }else {
                computer_play++;
            }
            displayBox();
        } else if (t1.getText().toString().equals(t5.getText().toString()) && t5.getText().toString().equals(t9.getText().toString()) && (t9.getText().toString().equals("X") || t9.getText().toString().equals("O"))) {
            winner=t1.getText().toString();
            if(winner.equals("X")){
                player++;
            }else {
                computer_play++;
            }
            displayBox();
        } else if (t3.getText().toString().equals(t5.getText().toString()) && t5.getText().toString().equals(t7.getText().toString()) && (t7.getText().toString().equals("X") || t7.getText().toString().equals("O"))) {
            winner=t3.getText().toString();
            if(winner.equals("X")){
                player++;
            }else {
                computer_play++;
            }
            displayBox();
        } else if(count>=5){
            // Toast.makeText(this, "No One Won, Game is restarted", Toast.LENGTH_SHORT).show();
            dialog.setContentView(R.layout.win_window);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            ImageView btn= dialog.findViewById(R.id.btn_restart);
            ImageView imageView=dialog.findViewById(R.id.imageView3);
            imageView.setImageResource(0);
            TextView tv=dialog.findViewById(R.id.id_winner);
            TextView tv1=dialog.findViewById(R.id.id_winner2);
            TextView tv2=dialog.findViewById(R.id.textView3);
            tv2.setText("Play");
            tv.setText("Game is Draw");
            tv1.setText("Play Again");
            btn.setImageResource(R.drawable.ic_play);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in=new Intent(getApplicationContext(),SinglePlay2.class);
                    in.putExtra("computer",String.valueOf(computer_play));
                    in.putExtra("player",String.valueOf(computer_play));
                    startActivity(in);
                    dialog.dismiss();
                    finish();
                }
            });

            dialog.show();

        }



    }

    private void displayBox() {
//        if(winner.equals("X"))
//            louser="O";
//        else
//            louser="X";
        dialog.setContentView(R.layout.win_window);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView btn= dialog.findViewById(R.id.btn_restart);
        ImageView close=dialog.findViewById(R.id.cancel);
        TextView tv=dialog.findViewById(R.id.id_winner);
        TextView tv1=dialog.findViewById(R.id.id_winner2);
        TextView tv2=dialog.findViewById(R.id.textView3);
        // TextView tv1=dialog.findViewById(R.id.id_louser);

        if(winner.equals("X")){
            tv.setText("Congratulation !!!");
        }else{
            ImageView imageView=dialog.findViewById(R.id.imageView3);
            imageView.setImageResource(0);
            tv.setText("You Lost game");
            tv1.setText("Play Again");
            tv2.setText("Restart Game");
        }
        // tv1.setText("The Loser is "+loser);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),GameOptions.class);
                startActivity(in);
                dialog.dismiss();
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),SinglePlay2.class);
                in.putExtra("computer",String.valueOf(computer_play));
                in.putExtra("player",String.valueOf(player));
                startActivity(in);
                dialog.dismiss();
                finish();
            }
        });
        dialog.show();
        occupied_space.clear();

//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setCancelable(true);
//        builder.setTitle("Game is Over");
//        builder.setMessage("Welcome ");
//        builder.setPositiveButton("Restart Game",
//                new DialogInterface.OnClickListener()
//                {
//                    public void onClick(DialogInterface dialog, int id)
//                    {
//                        t1.setText(null);t2.setText(null);t3.setText(null);t4.setText(null);t5.setText(null);t6.setText(null);
//                        t7.setText(null);t7.setText(null);t8.setText(null);t9.setText(null);
//                        count=0;
//                    }
//                });
//        builder.create().show();
    }

    public void click2(View view) {
        int click_value=2;
        t2.setText("X");
        occupied_space.add(2);
        clickStart(click_value);
        TextView tv=findViewById(R.id.text4);
        // tv.setClickable(false);
        tv.setOnClickListener(null);
    }

    public void click3(View view) {
        int click_value=3;
        t3.setText("X");
        occupied_space.add(3);
        clickStart(click_value);
        TextView tv=findViewById(R.id.text5);
        // tv.setClickable(false);
        tv.setOnClickListener(null);
    }

    public void click4(View view) {
        int click_value=4;
        t4.setText("X");
        occupied_space.add(4);
        clickStart(click_value);
        TextView tv=findViewById(R.id.text6);
        //tv.setClickable(false);
        tv.setOnClickListener(null);

    }

    public void click9(View view) {
        int click_value=9;
        t9.setText("X");
        occupied_space.add(9);
        clickStart(click_value);
        TextView tv=findViewById(R.id.text11);
        // tv.setClickable(false);
        tv.setOnClickListener(null);
    }

    public void click6(View view) {
        int click_value=6;
        t6.setText("X");
        occupied_space.add(6);
        clickStart(click_value);
        TextView tv=findViewById(R.id.text8);
        //tv.setClickable(false);
        tv.setOnClickListener(null);
    }

    public void click5(View view) {
        int click_value=5;
        t5.setText("X");
        occupied_space.add(5);
        clickStart(click_value);
        TextView tv=findViewById(R.id.text7);
        tv.setClickable(false);
        // tv.setOnClickListener(null);
    }

    public void click7(View view) {
        int click_value=7;
        t7.setText("X");
        occupied_space.add(7);
        clickStart(click_value);
        TextView tv=findViewById(R.id.text9);
        tv.setClickable(false);
        // tv.setOnClickListener(null);
    }

    public void click8(View view) {
        int click_value=8;
        t8.setText("X");
        occupied_space.add(8);
        clickStart(click_value);
        TextView tv=findViewById(R.id.text10);
        tv.setClickable(false);
        // tv.setOnClickListener(null);
    }

}
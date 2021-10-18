package com.example.zerocrossgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
int count=0;
String winner;
String louser;
Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.text3);
        t2=findViewById(R.id.text4);
        t3=findViewById(R.id.text5);
        t4=findViewById(R.id.text6);
        t5=findViewById(R.id.text7);
        t6=findViewById(R.id.text8);
        t7=findViewById(R.id.text9);
        t8=findViewById(R.id.text10);
        t9=findViewById(R.id.text11);
        dialog=new Dialog(this);
    }

    public void click1(View view) {

        if(count%2==0){
            t1.setText("O");
        }else{
            t1.setText("X");
        }
        gameStatus();
        count++;
        TextView tv=findViewById(R.id.text3);
        tv.setOnClickListener(null);
    }

    private void gameStatus() {
            if (t1.getText().toString().equals(t2.getText().toString()) && t2.getText().toString().equals(t3.getText().toString()) && (t3.getText().toString().equals("X") || t3.getText().toString().equals("O"))) {
                winner=t1.getText().toString();
                displayBox();
            } else if (t4.getText().toString().equals(t5.getText().toString()) && t5.getText().toString().equals(t6.getText().toString()) && (t6.getText().toString().equals("X") || t6.getText().toString().equals("O"))) {
                winner=t4.getText().toString();
                displayBox();
            } else if (t7.getText().toString().equals(t8.getText().toString()) && t8.getText().toString().equals(t9.getText().toString()) && (t9.getText().toString().equals("X") || t9.getText().toString().equals("O"))) {
                winner=t7.getText().toString();
                displayBox();
            } else if (t1.getText().toString().equals(t4.getText().toString()) && t4.getText().toString().equals(t7.getText().toString()) && (t7.getText().toString().equals("X") || t7.getText().toString().equals("O"))) {
                winner=t8.getText().toString();
                displayBox();
            } else if (t2.getText().toString().equals(t5.getText().toString()) && t5.getText().toString().equals(t8.getText().toString()) && (t8.getText().toString().equals("X") || t8.getText().toString().equals("O"))) {
                winner=t2.getText().toString();
                displayBox();
            } else if (t3.getText().toString().equals(t6.getText().toString()) && t6.getText().toString().equals(t9.getText().toString()) && (t9.getText().toString().equals("X") || t9.getText().toString().equals("O"))) {
                winner=t3.getText().toString();
                displayBox();
            } else if (t1.getText().toString().equals(t5.getText().toString()) && t5.getText().toString().equals(t9.getText().toString()) && (t9.getText().toString().equals("X") || t9.getText().toString().equals("O"))) {
                winner=t1.getText().toString();
                displayBox();
            } else if (t3.getText().toString().equals(t5.getText().toString()) && t5.getText().toString().equals(t7.getText().toString()) && (t7.getText().toString().equals("X") || t7.getText().toString().equals("O"))) {
                winner=t3.getText().toString();
                displayBox();
            } else if(count==8){
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
                        Intent in=new Intent(getApplicationContext(),MainActivity.class);
                        finish();
                        startActivity(in);
                        dialog.dismiss();
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
       // TextView tv1=dialog.findViewById(R.id.id_louser);
        tv.setText("Congratulation !!!  | "+winner+" |");
       // tv1.setText("The Loser is "+loser);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
                dialog.dismiss();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent in=new Intent(getApplicationContext(),MainActivity.class);
             startActivity(in);
                dialog.dismiss();
            }
        });
        dialog.show();

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

        if(count%2==0){
            t2.setText("O");
        }else{
            t2.setText("X");
        }
        gameStatus();
        count++;
        TextView tv=findViewById(R.id.text4);
       // tv.setClickable(false);
        tv.setOnClickListener(null);
    }

    public void click3(View view) {
        if(count%2==0){
            t3.setText("O");
        }else{
            t3.setText("X");
        }
        gameStatus();
        count++;
        TextView tv=findViewById(R.id.text5);
       // tv.setClickable(false);
        tv.setOnClickListener(null);
    }

    public void click4(View view) {
        if(count%2==0){
            t4.setText("O");
        }else{
            t4.setText("X");
        }
        gameStatus();
        count++;
        TextView tv=findViewById(R.id.text6);
        //tv.setClickable(false);
        tv.setOnClickListener(null);

    }

    public void click9(View view) {
        if(count%2==0){
            t9.setText("O");
        }else{
            t9.setText("X");
        }
        gameStatus();
        count++;
        TextView tv=findViewById(R.id.text11);
       // tv.setClickable(false);
        tv.setOnClickListener(null);
    }

    public void click6(View view) {
        if(count%2==0){
            t6.setText("O");
        }else{
            t6.setText("X");
        }
        gameStatus();
        count++;
        TextView tv=findViewById(R.id.text8);
        //tv.setClickable(false);
       tv.setOnClickListener(null);
    }

    public void click5(View view) {
        if(count%2==0){
            t5.setText("O");
        }else{
            t5.setText("X");
        }
        gameStatus();
        count++;
        TextView tv=findViewById(R.id.text7);
       tv.setClickable(false);
       // tv.setOnClickListener(null);
    }

    public void click7(View view) {
        if(count%2==0){
            t7.setText("O");
        }else{
            t7.setText("X");
        }
        gameStatus();
        count++;
        TextView tv=findViewById(R.id.text9);
        tv.setClickable(false);
       // tv.setOnClickListener(null);
    }

    public void click8(View view) {
        if(count%2==0){
            t8.setText("O");
        }else{
            t8.setText("X");
        }
        gameStatus();
        count++;
        TextView tv=findViewById(R.id.text10);
        tv.setClickable(false);
       // tv.setOnClickListener(null);
    }
}
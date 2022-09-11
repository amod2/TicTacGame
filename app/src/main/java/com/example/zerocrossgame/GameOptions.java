package com.example.zerocrossgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameOptions extends AppCompatActivity {
TextView tv_single,tv_two,tv_online;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_options);
        tv_single=findViewById(R.id.single_play);
        tv_two=findViewById(R.id.two_player);
        tv_online=findViewById(R.id.online_play);
        tv_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(getApplicationContext(),SinglePlay.class));
            }
        });
        tv_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }

    public void online(View view) {
        Toast.makeText(getApplicationContext(), "This option will coming soon", Toast.LENGTH_SHORT).show();
    }
}
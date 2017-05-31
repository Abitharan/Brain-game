package com.example.gamecoursework.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secPage extends AppCompatActivity {
    Button novice;
    Button easy;
    Button medium;
    Button guru;
    String gameLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_page);
        novice = (Button) findViewById(R.id.novice);
        easy = (Button) findViewById(R.id.easy);
        medium = (Button) findViewById(R.id.medium);
        guru = (Button) findViewById(R.id.guru);


        novice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(secPage.this, Calculator.class);
                gameLevel = "novice";
                intent.putExtra("gameType", gameLevel);
                startActivity(intent);
            }
        });

        easy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(secPage.this, Calculator.class);
                gameLevel = "easy";
                intent.putExtra("gameType", gameLevel);
                startActivity(intent);
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(secPage.this, Calculator.class);
                gameLevel = "medium";
                intent.putExtra("gameType", gameLevel);
                startActivity(intent);
            }
        });

        guru.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(secPage.this, Calculator.class);
                gameLevel = "guru";
                intent.putExtra("gameType", gameLevel);
                startActivity(intent);
            }
        });
    }
}

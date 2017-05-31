package com.example.gamecoursework.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartPage extends AppCompatActivity {

    Button continueGame;
    Button newGame;
    Button aboutGame;
    Button exitGame;

    private void inti() {
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPage.this, secPage.class);
                startActivity(intent);
            }
        });

        aboutGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPage.this, About.class);
                startActivity(intent);
            }
        });

        continueGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // To do code
            }
        });

        exitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        newGame = (Button) findViewById(R.id.newButton);
        aboutGame = (Button) findViewById(R.id.aboutButton);
        continueGame = (Button) findViewById(R.id.continueButton);
        exitGame = (Button) findViewById(R.id.exitButtton);
        inti();

    }
}

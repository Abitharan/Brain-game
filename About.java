package com.example.gamecoursework.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {
    TextView aboutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        aboutButton = (TextView) findViewById(R.id.gameContent);
        aboutButton.setText("");
    }
}

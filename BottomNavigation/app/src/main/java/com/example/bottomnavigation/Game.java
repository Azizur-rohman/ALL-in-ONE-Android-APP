package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game extends AppCompatActivity {
    private Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().setTitle("Game");
        button1=(Button)findViewById(R.id.btn1);
        button2=(Button)findViewById(R.id.btn2);
        button3=(Button)findViewById(R.id.btn3);

    }

    public void tamplerun(View view) {
        Intent intent = new Intent(Game.this,Tample_Run.class);
        startActivity(intent);
    }

    public void ludo(View view) {
        Intent intent = new Intent(Game.this,Ludo.class);
        startActivity(intent);

    }

    public void Bubbleshooter(View view) {
        Intent intent = new Intent(Game.this,Bubble_Shooter.class);
        startActivity(intent);

    }

    public void minigolf(View view) {
        Intent intent = new Intent(Game.this,MiniGolf.class);
        startActivity(intent);
    }
}

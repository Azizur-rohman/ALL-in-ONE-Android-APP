package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Unitconverter extends AppCompatActivity {

 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unitconverter);
        getSupportActionBar().setTitle("UnitConverter");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void temperature(View view) {
        Intent intent = new Intent(Unitconverter.this,FcActivity.class);
        startActivity(intent);

    }


    public void currency(View view) {
        Intent intent = new Intent(Unitconverter.this,cuActivity.class);
        startActivity(intent);
    }

    public void length(View view) {
        Intent intent = new Intent(Unitconverter.this,LeActivity.class);
        startActivity(intent);
    }

    public void area(View view) {
        Intent intent = new Intent(Unitconverter.this,ArActivity.class);
        startActivity(intent);
    }

    public void weight(View view) {
        Intent intent = new Intent(Unitconverter.this,WeActivity.class);
        startActivity(intent);
    }

    public void time(View view) {
        Intent intent = new Intent(Unitconverter.this,TiActivity.class);
        startActivity(intent);
    }

}

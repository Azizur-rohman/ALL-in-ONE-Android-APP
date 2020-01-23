package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;



public class Bubble_Shooter extends AppCompatActivity {
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble__shooter);
        getSupportActionBar().setTitle("Bubble Shooter");
        webView=(WebView)findViewById(R.id.game);


        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://html5.gamemonetize.com/03d7yfjdawlj2wx08gospclx508ejfxk/");

    }



}

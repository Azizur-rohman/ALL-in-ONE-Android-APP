package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mydetails extends AppCompatActivity {
    private Button btnviewdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydetails);
        btnviewdatabase=(Button)findViewById(R.id.viewdata);
        btnviewdatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mydetails.this,viewdatabase.class);
                startActivity(intent);
            }
        });
    }
}

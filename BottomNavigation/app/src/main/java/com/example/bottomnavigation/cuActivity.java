package com.example.bottomnavigation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class cuActivity extends AppCompatActivity {

    private Spinner spinner;
    EditText temp1;
    RadioButton rr1;
    RadioButton rr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        temp1 = (EditText) findViewById(R.id.editText2);
        rr1 = (RadioButton)findViewById(R.id.r1);
        rr2 = (RadioButton)findViewById(R.id.r2);

    }

    public void cuconvert(View view) {
        try { double value = new Double(temp1.getText().toString());
        if(rr1.isChecked())
            value = covertformula.currency(value);
        else
            value= covertformula.ccurrency(value);
        temp1.setText(new Double(value).toString());
        } catch (Exception e){
            Toast.makeText(getApplicationContext(),"Please Enter Value",Toast.LENGTH_SHORT).show();
        }
    }

}

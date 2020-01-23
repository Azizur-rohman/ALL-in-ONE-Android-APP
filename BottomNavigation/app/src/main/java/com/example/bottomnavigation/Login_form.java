package com.example.bottomnavigation;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Login_form extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;
    Button button;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login Form");
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        editText1 = (EditText) findViewById(R.id.ed1);
        editText2 = (EditText) findViewById(R.id.ed2);
        button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(this);

    }

    public void rgfm(View view) {
        Intent intent=new Intent(Login_form.this,Singup_form.class);
        startActivity(intent);
    }
    private void userLogin()
    {

           String email = editText1.getText().toString().trim();

           String password = editText2.getText().toString().trim();

           if (TextUtils.isEmpty(email)) {
               Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
               return;
           }
           if (TextUtils.isEmpty(password)) {
               Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
               return;
           }
           progressDialog.setMessage("Login...");
           progressDialog.show();

           firebaseAuth.signInWithEmailAndPassword(email, password)
                   .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {

                           if (task.isSuccessful()) {
                               startActivity(new Intent(getApplicationContext(),MainActivity.class));
                               finish();
                               Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();

                           }
                           else
                           {
                               Toast.makeText(getApplicationContext(),"Incurrect Email or Password",Toast.LENGTH_SHORT).show();
                           }

                           progressDialog.dismiss();
                       }
                   });

    }






    @Override
    public void onClick(View v) {

           if(v == button)
           {
               userLogin();
           }


    }
}

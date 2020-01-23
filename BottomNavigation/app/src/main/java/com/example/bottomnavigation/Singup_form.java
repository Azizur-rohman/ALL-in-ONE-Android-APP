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
import android.widget.RadioButton;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


public class Singup_form extends AppCompatActivity implements View.OnClickListener {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    RadioButton radioButton1;
    RadioButton radioButton2;
    Button button;
    ImageView imageView;
    static int PReqcode = 1;
    static int REQUESCODE = 1;
    Uri pickedImgUri;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    String gender="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_form);
        getSupportActionBar().setTitle("Signup Form");
        imageView =(ImageView)findViewById(R.id.navuPhotos);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Userinformation");
        editText1 =(EditText)findViewById(R.id.edtxt1);
        editText2 =(EditText)findViewById(R.id.edtxt2);
        editText3 =(EditText)findViewById(R.id.edtxt3);
        editText4 =(EditText)findViewById(R.id.edtxt4);
        editText5 =(EditText)findViewById(R.id.edtxt5);
        radioButton1 =(RadioButton)findViewById(R.id.rbtn1);
        radioButton2 =(RadioButton)findViewById(R.id.rbtn2);
        button=(Button)findViewById(R.id.regisbtn);
        button.setOnClickListener(this);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >=22)
                {
                    checkAndRequestForPermission();
                }else
                {
                    openGallary();
                }
            }
        });


    }
    private void checkAndRequestForPermission() {
        if(ContextCompat.checkSelfPermission(Singup_form.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)

        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(Singup_form.this,Manifest.permission.READ_EXTERNAL_STORAGE))

            {
                Toast.makeText(Singup_form.this,"Please accept for required permission",Toast.LENGTH_SHORT).show();
            }
            else
            {
                ActivityCompat.requestPermissions(Singup_form.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PReqcode);
            }
        }else
        {
            openGallary();
        }
    }

    private void registerUser() {
        final String fullname = editText1.getText().toString();
        final String username = editText2.getText().toString();
        final String email = editText3.getText().toString();
        String password = editText4.getText().toString();
        String confirmpassword = editText5.getText().toString();
        if(radioButton1.isChecked())
        {
            gender="Mail";
        }
        if(radioButton2.isChecked())
        {
            gender="Femail";
        }

        if(TextUtils.isEmpty(fullname))
        {
            Toast.makeText(this,"Please Enter Full Name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(username))
        {
            Toast.makeText(this,"Please Enter User Name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"Please Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.length() <8 )
        {
            Toast.makeText(this,"Password must be >=8 characters",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(confirmpassword))
        {
            Toast.makeText(this,"Please Enter Confirm Password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Userinformation userinformation = new Userinformation(
                                    fullname,username, email,gender
                            );
                            updateUserInfo(pickedImgUri, firebaseAuth.getCurrentUser());

                            FirebaseDatabase.getInstance().getReference("Userinformation")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(userinformation).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getApplicationContext(),"Registretion Complete",Toast.LENGTH_SHORT).show();
                                    finish();
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                }
                            });

                        }else
                        {
                            Toast.makeText(Singup_form.this,"Could not register.Please try again",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
    private void updateUserInfo(Uri pickedImgUri, FirebaseUser currentUser) {
        StorageReference mStorage= FirebaseStorage.getInstance().getReference().child("Users_Photos");
        StorageReference imagefilepath=mStorage.child(pickedImgUri.getLastPathSegment());

        imagefilepath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imagefilepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                                .setPhotoUri(uri).build();
                        currentUser.updateProfile(profileUpdate)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful())
                                        {
                                            upDateUI();
                                        }


                                    }
                                });

                    }
                });
            }
        });
    }
    private void upDateUI() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
    private void openGallary()
    {
        Intent gallaryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        gallaryIntent.setType("image/*");
        startActivityForResult(gallaryIntent, (Integer) REQUESCODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode ==RESULT_OK && requestCode == REQUESCODE && data != null)
        {
            pickedImgUri = data.getData();
            imageView.setImageURI(pickedImgUri);
        }


    }
    @Override
    public void onClick(View v) {

        if(v == button)
        {
            registerUser();

        }

    }


}

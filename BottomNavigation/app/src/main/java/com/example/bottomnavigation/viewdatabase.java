package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewdatabase extends AppCompatActivity {
    private FirebaseDatabase mfirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private DatabaseReference myref;
    private String userID;
    private ListView listView;
    private static final String TAG = "viewdatabase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdatabase);
        listView=(ListView)findViewById(R.id.listdata);
        mAuth = FirebaseAuth.getInstance();
        mfirebaseDatabase=FirebaseDatabase.getInstance();
        myref=mfirebaseDatabase.getReference();
        FirebaseUser user=mAuth.getCurrentUser();
        userID=user.getUid();
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren())
        {
            UserInfo userInfo = new UserInfo();
            userInfo.setEmail(ds.child(userID).getValue(UserInfo.class).getEmail());
            userInfo.setFullName(ds.child(userID).getValue(UserInfo.class).getFullName());
            userInfo.setGender(ds.child(userID).getValue(UserInfo.class).getGender());
            userInfo.setUserName(ds.child(userID).getValue(UserInfo.class).getUserName());
            Log.d(TAG,"email:" +userInfo.getEmail());
            Log.d(TAG,"fullName:" +userInfo.getFullName());
            Log.d(TAG,"gender:" +userInfo.getGender());
            Log.d(TAG,"userName:" +userInfo.getUserName());
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(userInfo.getEmail());
            arrayList.add(userInfo.getFullName());
            arrayList.add(userInfo.getGender());
            arrayList.add(userInfo.getUserName());
            ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);

        }

    }


}

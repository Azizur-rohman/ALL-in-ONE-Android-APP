package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout d1;
    private ActionBarDrawerToggle abdt;
    FirebaseUser currentUser;
    FirebaseAuth mAuth;


    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        System.exit(1);




    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth=FirebaseAuth.getInstance();
        currentUser=mAuth.getCurrentUser();
        d1 = (DrawerLayout)findViewById(R.id.d1);
        abdt = new ActionBarDrawerToggle(this,d1,R.string.nev_open,R.string.nev_close);
        abdt.setDrawerIndicatorEnabled(true);
        d1.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);
        updateNavheader();

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.homemenuId)
                {
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }

                if(id == R.id.nav_calculator)
                {
                    Intent intent = new Intent(MainActivity.this,Calculator.class);
                        startActivity(intent);
                }
                if(id == R.id.nav_unitconverter)
                {
                    Intent intent = new Intent(MainActivity.this,Unitconverter.class);
                    startActivity(intent);
                }
                if(id == R.id.sharemenuId)
                {
                    Intent intent = new Intent(MainActivity.this,Game.class);
                    startActivity(intent);
                }
                if(id == R.id.userinfomenuId)
                {
                    Intent intent = new Intent(MainActivity.this,Mydetails.class);
                    startActivity(intent);
                }
                if(id == R.id.exit)
                {
                    mAuth.signOut();
                    finish();
                    startActivity(new Intent(MainActivity.this,Login_form.class));
                }
                return true;
            }
        });

        BottomNavigationView bottomNavigationView =(BottomNavigationView)findViewById(R.id.bottom_nav);
       bottomNavigationView.setOnNavigationItemSelectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new Clock()).commit();


    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId())
                    {
                        case R.id.nav_clock:
                            selectedFragment = new Clock();
                            break;
                        case R.id.nav_calendar:
                            selectedFragment = new Calendar();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,selectedFragment).commit();
                    return true;
                }
            };
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }


    public void updateNavheader()
    {
        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);
        View headerView = nav_view.getHeaderView(0);

        TextView navEmail=headerView.findViewById(R.id.headertv2);
        ImageView navImg=headerView.findViewById(R.id.nav_photo);

        navEmail.setText(currentUser.getEmail());
        Glide.with(this).load(currentUser.getPhotoUrl()).into(navImg);

    }

}

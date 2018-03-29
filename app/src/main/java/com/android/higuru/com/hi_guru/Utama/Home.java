package com.android.higuru.com.hi_guru.Utama;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.higuru.com.hi_guru.Database.DatabaseHelper;
import com.android.higuru.com.hi_guru.Guru.Guru;
import com.android.higuru.com.hi_guru.Profil.Profile;
import com.android.higuru.com.hi_guru.R;

public class Home extends AppCompatActivity {
    private static Button button_log;
    DatabaseHelper MyDB;
    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MyDB = new DatabaseHelper(this);
        button_log = (Button) findViewById(R.id.btnLogout);
        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(Home.this);
                a_builder.setMessage("Anda yakin ingin keluar?")
                        .setCancelable(false)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MyDB.HapusData();
                                finish();
                                Intent intent = new Intent(Home.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                dialog.cancel();
                            }

                        });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Keluar?");
                alert.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            return true;
        }
        else if(id == R.id.action_aboutus){
            Intent i = new Intent(Home.this, AboutUs.class);
            startActivity(i);

            return true;
        }
        else if(id == R.id.action_logout){
            Intent i = new Intent(Home.this,LoginActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan sekali lagi untuk keluar aplikasi !!!", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    public void guru(View view) {
        Intent i = new Intent(Home.this, Guru.class);
        startActivity(i);
    }

    public void privat(View view) {
        Intent i = new Intent(Home.this, Private.class);
        startActivity(i);
    }

    public void vote(View view) {
        Intent i = new Intent(Home.this, Vote.class);
        startActivity(i);
    }

    public void contact(View view) {
        Intent i = new Intent(Home.this, Contact.class);
        startActivity(i);
    }

    public void profile(View view) {
        Intent i = new Intent(Home.this, Profile.class);
        startActivity(i);
    }



}

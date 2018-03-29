package com.android.higuru.com.hi_guru.Utama;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.android.higuru.com.hi_guru.R;
import com.android.higuru.com.hi_guru.Utama.LoginActivity;

public class SplashscreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Thread MyThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent); // menghubungkan activity splashscren ke main activity dengan intent

                    //jeda selesai Splashscreen
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        MyThread.start();
    }
}
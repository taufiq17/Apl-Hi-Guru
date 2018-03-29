package com.android.higuru.com.hi_guru.DetailGuru;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.higuru.com.hi_guru.Utama.AboutUs;
import com.android.higuru.com.hi_guru.Utama.LoginActivity;
import com.android.higuru.com.hi_guru.Pemesanan.Pemesanan;
import com.android.higuru.com.hi_guru.R;

public class DetailGuru extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailguru);

        //mengubah font button pilih menjadi disparador stencil
        String customFont = "disparador_stencil.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);
        Button btnPilih = (Button) findViewById(R.id.button_pilih);
        btnPilih.setTypeface(typeface);

        //pendeklarasian toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //pendeklarasian action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            return true;
        }
        else if(id == R.id.action_aboutus){
            Intent i = new Intent(DetailGuru.this, AboutUs.class);
            startActivity(i);

            return true;
        }
        else if(id == R.id.action_logout){
            Intent i = new Intent(DetailGuru.this,LoginActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void pemesanan (View view) {
        Intent i = new Intent(DetailGuru.this, Pemesanan.class);
        startActivity(i);
    }

}

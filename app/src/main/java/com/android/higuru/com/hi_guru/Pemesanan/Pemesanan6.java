package com.android.higuru.com.hi_guru.Pemesanan;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.higuru.com.hi_guru.Utama.AboutUs;
import com.android.higuru.com.hi_guru.Utama.LoginActivity;
import com.android.higuru.com.hi_guru.R;

public class Pemesanan6 extends AppCompatActivity{
    Button btnPilih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan6);

        btnPilih = (Button) findViewById(R.id.button_pilih);
        btnPilih.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Context context = getApplicationContext();
                CharSequence text = "Selamat !!! Pemesanan telah berhasil. " +
                        "Anda memilih Tri Astuti, M. Pd sebagai guru les";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        });

        String customFont = "disparador_stencil.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);
        Button btnPilih = (Button) findViewById(R.id.button_pilih);
        btnPilih.setTypeface(typeface);

        ImageButton back =(ImageButton) findViewById(R.id.back);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
            Intent i = new Intent(Pemesanan6.this, AboutUs.class);
            startActivity(i);

            return true;
        }
        else if(id == R.id.action_logout){
            Intent i = new Intent(Pemesanan6.this,LoginActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

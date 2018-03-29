package com.android.higuru.com.hi_guru.Guru;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.higuru.com.hi_guru.Utama.AboutUs;
import com.android.higuru.com.hi_guru.Utama.Home;
import com.android.higuru.com.hi_guru.Utama.LoginActivity;
import com.android.higuru.com.hi_guru.R;


public class Guru extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guru);

        String customFont = "a_SimplerBUB&W Bold.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);
        TextView textView = (TextView) findViewById(R.id.textViewWelcome);
        textView.setTypeface(typeface);

        ImageButton back =(ImageButton) findViewById(R.id.back);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //menghubungkan antar activity dengan intent
                Intent pindah = new Intent(Guru.this,Home.class);
                startActivity(pindah);
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
            Intent i = new Intent(Guru.this, AboutUs.class);
            startActivity(i);

            return true;
        }
        else if(id == R.id.action_logout){
            Intent i = new Intent(Guru.this,LoginActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tampilguru(View view) {
        Intent i = new Intent(Guru.this, TampilGuru.class);
        startActivity(i);
    }
}

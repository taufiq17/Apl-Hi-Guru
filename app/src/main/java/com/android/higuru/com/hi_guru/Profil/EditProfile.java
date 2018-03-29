package com.android.higuru.com.hi_guru.Profil;

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

import com.android.higuru.com.hi_guru.Utama.AboutUs;
import com.android.higuru.com.hi_guru.Utama.LoginActivity;
import com.android.higuru.com.hi_guru.R;

public class EditProfile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        String customFont = "disparador_stencil.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);
        Button btnBatal = (Button) findViewById(R.id.btnBatal);
        btnSimpan.setTypeface(typeface);
        btnBatal.setTypeface(typeface);

        ImageButton back =(ImageButton) findViewById(R.id.back);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //menghubungkan antar activity dengan intent
                Intent pindah = new Intent(EditProfile.this,Profile.class);
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
            Intent i = new Intent(EditProfile.this, AboutUs.class);
            startActivity(i);

            return true;
        }
        else if(id == R.id.action_logout){
            Intent i = new Intent(EditProfile.this,LoginActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

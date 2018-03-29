package com.android.higuru.com.hi_guru.Utama;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.higuru.com.hi_guru.R;

public class Contact extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        //pendeklarasian tombol back
        ImageButton back =(ImageButton) findViewById(R.id.back);

        //pendeklarasian toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //menghubungkan antar activity dengan intent
                Intent pindah = new Intent(Contact.this,Home.class);
                startActivity(pindah);
            }
        });

        TextView tv = (TextView) findViewById(R.id.textView3);
        tv.setAutoLinkMask(Linkify.ALL);

        FloatingActionButton send = (FloatingActionButton) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:085727740114");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(it);
            }
        });

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
            Intent i = new Intent(Contact.this, AboutUs.class);
            startActivity(i);

            return true;
        }
        else if(id == R.id.action_logout){
            Intent i = new Intent(Contact.this,LoginActivity.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
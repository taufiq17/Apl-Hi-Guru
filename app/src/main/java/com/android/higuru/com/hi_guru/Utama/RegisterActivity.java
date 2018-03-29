package com.android.higuru.com.hi_guru.Utama;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.higuru.com.hi_guru.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText namalengkap;
    private EditText nik;
    private EditText alamat;
    private EditText email;
    private EditText password;
    private EditText telp;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        namalengkap = (EditText) findViewById(R.id.input_namalengkap);
        nik = (EditText) findViewById(R.id.input_nik);
        alamat = (EditText) findViewById(R.id.input_alamat);
        email = (EditText) findViewById(R.id.input_email);
        password = (EditText) findViewById(R.id.input_password);
        telp = (EditText) findViewById(R.id.input_telp);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Context context = getApplicationContext();
                CharSequence text = "Selamat !!! Registrasi telah berhasil";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        });
    }


    public void login(View view) {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }

}



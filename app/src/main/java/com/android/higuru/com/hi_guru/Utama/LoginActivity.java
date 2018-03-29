package com.android.higuru.com.hi_guru.Utama;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.higuru.com.hi_guru.Database.DatabaseHelper;
import com.android.higuru.com.hi_guru.R;


public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPass;
    Button btnLogin;
    TextView lupaPassTxt;
    TextView registerTxt;
    String Email ="maman@gmail.com";
    String Password = "maman";
    DatabaseHelper MyDB;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String customFont = "disparador_stencil.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setTypeface(typeface);

        MyDB = new DatabaseHelper(this);
        Cursor res = MyDB.LihatData();
        if (res.moveToNext()) {
            finish();
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }
        etEmail = (EditText) findViewById(R.id.input_email);
        etPass = (EditText) findViewById(R.id.input_password_login);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        lupaPassTxt = (TextView) findViewById(R.id.textViewLupaPass);
        registerTxt = (TextView) findViewById(R.id.txtRegister);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login() {
        String Mail = etEmail.getText().toString();
        String Pass = etPass.getText().toString();
        if (Mail.equals("") || Pass.equals("")) {
            Toast.makeText(this, "Email dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
        } else {
            if (!Mail.equals(Email) || !Pass.equals(Password)) {
                Toast.makeText(this, "Email atau Password Salah!", Toast.LENGTH_SHORT).show();
            } else if (Mail.equals(Email) && Pass.equals(Password)) {
                Toast.makeText(this, "Selamat, Anda Berhasil Login!", Toast.LENGTH_LONG).show();
                MyDB.SimpanData(Mail, Pass);
                finish();
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
            }

        }

        String Mail1 = etEmail.getText().toString();
        String Pass1 = etPass.getText().toString();
        if (Mail.equals("") || Pass.equals("")) {
            Toast.makeText(this, "Email dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
        } else {
            if (!Mail1.equals(Email) || !Pass1.equals(Password)) {
                Toast.makeText(this, "Email atau Password Salah!", Toast.LENGTH_SHORT).show();
            } else if (Mail1.equals(Email) && Pass1.equals(Password)) {
                Toast.makeText(this, "Selamat, Anda Berhasil Login!", Toast.LENGTH_LONG).show();
                MyDB.SimpanData(Mail1, Pass1);
                finish();
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
            }
        }
    };


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


    public void register(View view) {
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
    }

    public void home(View view) {
        Intent j = new Intent(LoginActivity.this, Home.class);
        startActivity(j);
    }

}




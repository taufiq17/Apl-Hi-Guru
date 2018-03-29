package com.android.higuru.com.hi_guru.Guru;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.higuru.com.hi_guru.R;


public class CbSpinner extends Activity{
    Spinner spinnertingkat;
    Spinner spinnermapel;
    String[] tingkat;
    String[] mapel;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_guru);
        spinnertingkat = (Spinner) findViewById(R.id.SpinnerTingkat);
        tingkat = getResources().getStringArray(R.array.tingkat);
        spinnertingkat.setPrompt("Pilih Tingkat");

        spinnermapel = (Spinner) findViewById(R.id.SpinnerMapel);
        mapel = getResources().getStringArray(R.array.mapel);
        spinnermapel.setPrompt("Pilih Mata Pelajaran");

    }
}


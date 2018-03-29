package com.android.higuru.com.hi_guru.Guru;

import android.content.Intent;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.higuru.com.hi_guru.DetailGuru.DetailGuru;
import com.android.higuru.com.hi_guru.DetailGuru.DetailGuru2;
import com.android.higuru.com.hi_guru.DetailGuru.DetailGuru3;
import com.android.higuru.com.hi_guru.DetailGuru.DetailGuru4;
import com.android.higuru.com.hi_guru.DetailGuru.DetailGuru5;
import com.android.higuru.com.hi_guru.DetailGuru.DetailGuru6;
import com.android.higuru.com.hi_guru.R;

import java.util.ArrayList;
import java.util.HashMap;


public class TampilGuru extends ListActivity {

    //Aray list akan di simpan di dalam searchResults
    ArrayList<HashMap<String, Object>> searchResults;

    //ArrayList akan menyimpan data asli dari originalValues
    ArrayList<HashMap<String, Object>> originalValues;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilguru);

        final EditText pencarian=(EditText) findViewById(R.id.pencarian);
        ListView playersListView=(ListView) findViewById(android.R.id.list);

        //mengambil LayoutInflater untuk inflating thcustomView
        //disini akan menggunakan custom adapter
        inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //disini data aray akan di deklarasikan
        //dan akan disimpan ke dalam Arraylist
        //tipe data string untuk textview integer untuk gambar icon
        String namaguru[]={"Anom Sejogati, S.Kom","M. Rizaluddin, M.Kom","Alfian Chandra, S.Kom","Imam Prayogo, S.Kom", "Dicky Anggriawan, S.Kom","Tri Astuti, M.Kom"};
        String mapel []={"Bahasa Inggris","Bahasa Indonesia","Bahasa Arab","Matematika","IPA","IPS"};
        String alamat[]={"Sapugarut, Buaran","Wonopringgo","Temanggung","Bojong","Kajen","Banjarnegara"};
        Integer[] icons ={R.drawable.anom,R.drawable.rizal,R.drawable.chandra,R.drawable.imam,R.drawable.dicky,R.drawable.tri};
        originalValues=new ArrayList<HashMap<String,Object>>();

        //hasmap akan menyimpan data sementara dalam listview
        HashMap<String , Object> temp;

        //jumlah baris dalam ListView
        int noOfPlayers=namaguru.length;

        //pengulangan dalam Arraylist
        for(int i=0;i<noOfPlayers;i++)
        {
            temp=new HashMap<String, Object>();

            temp.put("namaguru", namaguru[i]);
            temp.put("mapel", mapel[i]);
            temp.put("alamat", alamat[i]);
            temp.put("icon", icons[i]);

            //menambah kan baris ke dalam  ArrayList
            originalValues.add(temp);
        }
        //searchResults sama dengan OriginalValues
        searchResults=new ArrayList<HashMap<String,Object>>(originalValues);

        //membuat adapter
        //first param-the context
        //second param-the id of the layout file
        //you will be using to fill a row
        //third param-the set of values that
        //will populate the ListView
        final CustomAdapter adapter=new CustomAdapter(this, R.layout.list_guru,searchResults);

        //menset adapter di dalam listview
        playersListView.setAdapter(adapter);
        pencarian.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //mengambil text di dalam  EditText
                String searchString=pencarian.getText().toString();
                int textLength=searchString.length();
                searchResults.clear();

                for(int i=0;i<originalValues.size();i++)
                {
                    String playerName=originalValues.get(i).get("namaguru").toString();
                    if(textLength<=playerName.length()){
                        //membandingkan data String didalam EditText dengan namabarangs  di dalam ArrayList
                        if(searchString.equalsIgnoreCase(playerName.substring(0,textLength)))
                            searchResults.add(originalValues.get(i));
                    }}
                adapter.notifyDataSetChanged();
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {}

            public void afterTextChanged(Editable s) {}
        });
    }


    //mendefinisikan custom adapter
    private class CustomAdapter extends ArrayAdapter<HashMap<String, Object>>
    {
        public CustomAdapter(Context context, int textViewResourceId,
                             ArrayList<HashMap<String, Object>> Strings) {


            super(context, textViewResourceId, Strings);
        }

        //class untuk menyimpan baris konten (cacheview) di listview
        private class ViewHolder
        {
            ImageView icon;
            TextView namaguru,mapel,alamat;
        }

        ViewHolder viewHolder;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView==null)
            {
                convertView=inflater.inflate(R.layout.list_guru, null);
                viewHolder=new ViewHolder();

                //isi konten (cache the views)
                viewHolder.icon=(ImageView) convertView.findViewById(R.id.icon);
                viewHolder.namaguru=(TextView) convertView.findViewById(R.id.namaguru);
                viewHolder.mapel=(TextView) convertView.findViewById(R.id.mapel);
                viewHolder.alamat=(TextView) convertView.findViewById(R.id.alamat);

                //menghubungkan cached views ke dalam convertview
                convertView.setTag(viewHolder);
            }
            else
                viewHolder=(ViewHolder) convertView.getTag();
            int iconId=(Integer) searchResults.get(position).get("icon");

            //menset data untuk ditampilkan
            viewHolder.icon.setImageDrawable(getResources().getDrawable(iconId));
            viewHolder.namaguru.setText(searchResults.get(position).get("namaguru").toString());
            viewHolder.mapel.setText(searchResults.get(position).get("mapel").toString());
            viewHolder.alamat.setText(searchResults.get(position).get("alamat").toString());
            //mengembalikan view untuk ditampilkan
            return convertView;
        }
    }
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);//menggunakan method onliistitemclick dan mencarinya
        //berdasarkan posisi
        String str = searchResults.get(position).get("namaguru").toString();
        try{
            if(str=="Anom Sejogati, S.Kom"){
                Intent i = new Intent(TampilGuru.this, DetailGuru.class);
                startActivity(i);
                //Toast.makeText(getApplicationContext(), "Nama Guru Les yang Anda pilih Anom Sejogati", Toast.LENGTH_SHORT).show();
                //menampilkan pesan text toast saat nama barang diklik kalian bisa mengganti intent di baris ini
            }
            if(str=="M. Rizaluddin, M.Kom"){
                Intent i = new Intent(TampilGuru.this, DetailGuru2.class);
                startActivity(i);
            }
            if(str=="Alfian Chandra, S.Kom"){
                Intent i = new Intent(TampilGuru.this, DetailGuru3.class);
                startActivity(i);
            }
            if(str=="Imam Prayogo, S.Kom"){
                Intent i = new Intent(TampilGuru.this, DetailGuru4.class);
                startActivity(i);
            }
            if(str=="Dicky Anggriawan, S.Kom"){
                Intent i = new Intent(TampilGuru.this, DetailGuru5.class);
                startActivity(i);
            }
            if(str=="Tri Astuti, M.Kom"){
                Intent i = new Intent(TampilGuru.this, DetailGuru6.class);
                startActivity(i);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}


package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button btn;
    ListView listView;
    ArrayList<Music>list_music = new ArrayList<>();
    ArrayList<Music> playList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnOk);
        listView = findViewById(R.id.listView);
        btn.setOnClickListener(listenerOk);



        this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CheckedTextView v = (CheckedTextView) view;
                boolean currentCheck = v.isChecked();
                Music myPlaylist = (Music) listView.getItemAtPosition(i);
                myPlaylist.setActive(!currentCheck);
            }
        });

        this.initListViewData();


    }

    private void initListViewData()  {

        Uri aer = Uri.parse("android.resource://com.example.myapplication/aerosmith.mp3");
        Uri bitter_end = Uri.parse("android.resource://com.example.myapplication/bitter_end.mp3");
        Uri dreamon = Uri.parse("android.resource://com.example.myapplication/dream_on.mp3");
        Uri picture = Uri.parse("android.resource://com.example.myapplication/picture.mp3");
        Uri weeknd = Uri.parse("android.resource://com.example.myapplication/weeknd.mp3");
        String aero = "aerosmith";
        String bitter = "bitterend";
        String dream = "dreamon";
        String pic = "picture";
        String week = "weeknd";


        list_music.add(new Music(aero, aer));
        list_music.add(new Music(bitter, bitter_end));
        list_music.add(new Music(dream, dreamon));
        list_music.add(new Music(pic, picture));
        list_music.add(new Music(week, weeknd));


        ArrayAdapter<Music> arrayAdapter
                = new ArrayAdapter<Music>(this, android.R.layout.simple_list_item_multiple_choice , list_music);

        this.listView.setAdapter(arrayAdapter);

    }



    public void addPlaylistIsChecked() {

        SparseBooleanArray sp = listView.getCheckedItemPositions();

        for(int i=0;i<sp.size();i++){
            if(sp.valueAt(i)){
                Music music= (Music) listView.getItemAtPosition(i);
                playList.add(music);
            }
        }
    }


    public View.OnClickListener listenerOk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            addPlaylistIsChecked();

            for(int i=0;i<playList.size();i++) {
                Log.i("musiccc=========",playList.get(i).getTitleMusic());
            }

        }
    };




}
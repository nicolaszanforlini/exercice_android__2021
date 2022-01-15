package com.example.boutonzoom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnZoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnZoom = (Button) findViewById(R.id.btnZoom);

        btnZoom.setOnTouchListener(btnZoomListener);

    }

    private View.OnTouchListener btnZoomListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            Button button = (Button) v;
            int largeur = button.getWidth();
            int hauteur = button.getHeight();
            float x = event.getX();
            float y = event.getY();
            btnZoom.setTextSize(Math.abs(x - largeur / 2) + Math.abs(y - hauteur / 2));
            return false;
        }
    };



}
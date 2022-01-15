package com.example.permission;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.permission.Gestion_file;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private Boolean sdCardMounted = false;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // activate permission
        permission();

        // verification sdcard exist
        sdCardExist();


    }




    // methode permission granted for read and write
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void permission () {

        // permission for read file
        if( ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE ) == PackageManager.PERMISSION_DENIED ) {
            requestPermissions( new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE }, 1 );
            Log.i("permission read ", "ko change to ok" );
        }else{
            Log.i("permission read ", "ok" );
        }

        // permission for write in file
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck==PackageManager.PERMISSION_GRANTED) {
            Log.i("permission write ", "ok");
        }else{
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
            Log.i("permission write ", "ko change to ok");
        }
    }



    // verification sdcard exist
    public void sdCardExist() {
        if( Environment.getExternalStorageState().equals( Environment.MEDIA_MOUNTED ) ) {
            sdCardMounted = true;
            Log.i("sdcard ", "mounted" );
        }else{
            Log.i("sdcard ", "not mounted" );
        }
    }






}





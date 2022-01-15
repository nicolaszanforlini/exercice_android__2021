package com.example.permission;


import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gestion_file {

    private String name;
    private String texte;
    private FileInputStream fis = null;


    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setTexte(String texte) {
        this.texte = texte;
    }
    public String getTexte() {
        return this.texte;
    }

    Gestion_file (String n, String t) {
        setName(n);
        setTexte(t);
    }



    public void createFileInSdcard() throws IOException {

        try (FileOutputStream fos = new FileOutputStream(this.name)) {
            fos.write(this.texte.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String loadFileInSdcard(String s) {
        int i = -1;
        String str = "";
        try {
            fis = new FileInputStream(s);
            
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return str;
    }



}

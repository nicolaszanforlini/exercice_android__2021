package com.example.sharedpreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class Example extends PreferenceActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }

}




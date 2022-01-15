package com.example.myapplication;

import android.net.Uri;


class Music {

    private String titleMusic;
    private Uri uri;
    private Long duration;

    private boolean active;

    public Music(String t, Uri u) {
        this.titleMusic = t;
        this.uri = u;
        this.active = true;
    }


    public String getTitleMusic() {
        return this.titleMusic;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return this.titleMusic;
    }



}

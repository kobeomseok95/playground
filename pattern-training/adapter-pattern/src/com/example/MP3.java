package com.example;

public class MP3 implements MediaPlayer{

    @Override
    public void play(String filename) {
        System.out.println("Playing MP3 file = " + filename);
    }
}

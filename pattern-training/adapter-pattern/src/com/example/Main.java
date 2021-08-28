package com.example;

public class Main {

    public static void main(String[] args) {
        MediaPlayer mp3Player = new MP3();
        mp3Player.play("ex1.mp3");

        MediaPlayer mkvPlayer = new FormatAdapter(new MKV());
        mkvPlayer.play("ex2.mkv");

        MediaPlayer mp4Player = new FormatAdapter(new MP4());
        mp4Player.play("ex3.mp4");
    }
}

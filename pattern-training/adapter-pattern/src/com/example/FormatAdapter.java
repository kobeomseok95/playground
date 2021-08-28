package com.example;

public class FormatAdapter implements MediaPlayer{

    // MP4, MKV 파일
    private MediaPackage media;

    public FormatAdapter(MediaPackage media) {
        this.media = media;
    }

    @Override
    public void play(String filename) {
        System.out.println("=======Using Adapter=======");
        media.playFile(filename);
    }
}

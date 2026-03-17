package com.example.practice10.bai2;

public class Bai2 {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter();

        player.play("vlc", "movie.vlc");
        player.play("mp3", "song.mp3");
    }
}
package com.company.LinkedListChallenge;


import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private ArrayList<Song> albumInventory;

    public Album(String name) {
        this.name = name;
        this.albumInventory = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getAlbumInventory() {
        return albumInventory;
    }

    public boolean addSongToAlbum(String name, int duration) {
        Song entry = new Song(name, duration);
        if (!this.albumInventory.contains(entry)) {
            this.albumInventory.add(entry);
            return true;
        }
        return false;
    }

    public void printAlbumInventory() {
        System.out.println("Album name: " + this.name);
        for (Song song : this.albumInventory) {
            String minutes = "" + song.getDuration()/60;
            String seconds = "" + song.getDuration()%60;
            if (seconds.length()<=1){
                seconds+="0";
            }
            System.out.println((this.albumInventory.indexOf(song) + 1) +
                    ". Tittle: " + song.getTitle() + "\n    Duration: " + minutes + ":" + seconds);

        }
    }
}

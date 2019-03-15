package com.company.LinkedListChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MusicPlayer {
    private ArrayList<Album> albumArrayList = new ArrayList<Album>();
    private Album album1 = new Album("NFS:U2 Track mix");
    private Album album2 = new Album("Best radio mix #1");
    private Scanner scanner = new Scanner(System.in);
    private LinkedList<Song> playlist = new LinkedList<Song>();
    private ListIterator<Song> songListIterator;// = this.playlist.listIterator();
    private boolean skippedForward = false;
    private boolean skippedBackward = false;


    public void powerOn() {
        loadResources();
        boolean flag = true;
        printMenu();
        while (flag) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    printAlbums();
                    break;
                case 2:
                    printPlaylist();
                    break;
                case 3:
                    skipForward();
                    break;
                case 4:
                    skipBackward();
                    break;
                case 5:
                    replay();
                    break;
                case 6:
                    removeCurrentFromPlaylist();
                    break;
                case 7:
                    System.out.println("Powering off... Goodbye");
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }

    private void loadResources() {
        System.out.println("----------------------------------------------\n" +
                "Loading... Please wait\n" +
                "----------------------------------------------");
        album1.addSongToAlbum("Riders of The Storm", 240);
        album1.addSongToAlbum("Black Betty", 185);
        album1.addSongToAlbum("Speed demon", 162);
        album1.addSongToAlbum("Dogs", 223);
        album1.addSongToAlbum("Tokyo Drift", 284);

        album2.addSongToAlbum("Never gonna let you down", 234);
        album2.addSongToAlbum("You're beautiful", 420);
        album2.addSongToAlbum("Who let the dogs out", 210);
        album2.addSongToAlbum("Bandoleras", 123);
        album2.addSongToAlbum("Billy Jeans", 312);

        albumArrayList.add(album1);
        albumArrayList.add(album2);

        addToPlaylist("You're beautiful");
        addToPlaylist("Black Betty");
        addToPlaylist("Who let the dogs out");
        addToPlaylist("Dogs");
        addToPlaylist("Riders of The Storm");
        addToPlaylist("You're beautiful");
        addToPlaylist("Billy Jeans");
        addToPlaylist("Matrica");
        System.out.println("----------------------------------------------\n" +
                "Resources successfully loaded\n" +
                "----------------------------------------------");
        songListIterator = this.playlist.listIterator();
    }

    private Song getSongFromAlbum(String songName) {
        for (int i = 0; i < albumArrayList.size(); i++) {
            ArrayList<Song> album = albumArrayList.get(i).getAlbumInventory();
            for (int j = 0; j < album.size(); j++) {
                Song song = album.get(j);
                if (song.getTitle().equalsIgnoreCase(songName)) {
                    return song;
                }
            }
        }
        return null;
    }

    private void addToPlaylist(String songName) {
        Song song = getSongFromAlbum(songName);
        if (song != null) {
            boolean isInPlaylist = false;
            for (Song sip : this.playlist) {
                if (sip.equals(song)) {
                    isInPlaylist = true;
                    System.out.println('"' + songName + '"' + " is already in the playlist");
                }
            }
            if (!isInPlaylist) {
                this.playlist.add(song);
            }
        } else {
            System.out.println("No song by the name " + '"' + songName + '"' + " found");
        }
    }

    private void replay() {
        if (songListIterator.hasNext()) {
            if (songListIterator.hasPrevious()) {
                songListIterator.previous();
                System.out.println('"' + songListIterator.next().getTitle() + '"' + " is now playing");
            } else {
                System.out.println("Next happened");
                System.out.println('"' + songListIterator.next().getTitle() + '"' + " is now playing");
                songListIterator.previous();
            }

        } else if (songListIterator.hasPrevious()) {
            if (songListIterator.hasNext()) {
                songListIterator.next();
                System.out.println('"' + songListIterator.previous().getTitle() + '"' + " is now playing");
            } else {
                System.out.println("Previous happened");
                System.out.println('"' + songListIterator.previous().getTitle() + '"' + " is now playing");
                songListIterator.next();
            }
        }
    }

    private void skipForward() {
        if (!songListIterator.hasPrevious()) {
            songListIterator.next();
        }
        if (skippedBackward && songListIterator.hasNext()){
            songListIterator.next();
            skippedForward = true;
        }
        if (songListIterator.hasNext()) {
            System.out.println("Skipping to the next song");
            System.out.println('"' + songListIterator.next().getTitle() + '"' + " is now playing");
            skippedForward = true;
            skippedBackward = false;
        } else {
            System.out.println("No more songs in the playlist");
        }
    }

    private void skipBackward() {
        if (!songListIterator.hasNext()) {
            songListIterator.previous();
        }
        if (skippedForward && songListIterator.hasPrevious()){
            songListIterator.previous();
            skippedBackward = true;
        }
        if (songListIterator.hasPrevious()) {
            System.out.println("Skipping to the previous song");
            System.out.println('"' + songListIterator.previous().getTitle() + '"' + " is now playing");
            skippedForward = true;
            skippedBackward = false;
        } else {
            System.out.println("No way to go to previous. This already is the first song of the playlist");
        }
    }

    private void removeCurrentFromPlaylist() {
        System.out.println("Removing current song");
        songListIterator.remove();
    }

//    private void addInOrder(LinkedList<Song> playlist, String songName) {
//        ListIterator<Song> songListIterator = playlist.listIterator();
//        Song song = getSongFromAlbum(songName);
//        if (song != null) {
//            while (songListIterator.hasNext()) {
//                int comparison = songListIterator.next().getTitle().compareToIgnoreCase(songName);
//                if (comparison == 0) {
//                    System.out.println(songName + " is already in the playlist");
//                    return;
//                } else if (comparison > 0) {
//                    songListIterator.previous();
//                    songListIterator.add(song);
//                    return;
//                }
//            }
//            songListIterator.add(song);
//        } else {
//            System.out.println("No song by the name " + '"' + songName + '"' + " found");
//        }
//    }

    private void printAlbums() {
        for (int i = 0; i < albumArrayList.size(); i++) {
            albumArrayList.get(i).printAlbumInventory();
            System.out.println("-------------------------------------------");
        }
    }

    private void printPlaylist() {
        System.out.println("The current playlist contains songs as follows:");
        int i = 1;
        for (Song song : this.playlist) {
            System.out.println(i + ". " + song.getTitle() + "\n" +
                    "   Duration: " + song.getDuration());
            i++;
        }
    }

    private void printMenu() {
        System.out.println("Menu commands are as follows:\n" +
                "0 - Menu command list\n" +
                "1 - All album inventory list\n" +
                "2 - Current playlist inventory\n" +
                "3 - Skip forward to the next song\n" +
                "4 - Skip backward to the previous song\n" +
                "5 - Replay the current song\n" +
                "6 - Remove the current song from playlist\n" +
                "7 - Power off the music player");
    }
}

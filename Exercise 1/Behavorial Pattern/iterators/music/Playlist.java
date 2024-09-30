package music;

import java.util.ArrayList;
import java.util.Iterator;

public class Playlist implements Iterable<Song> {
    private ArrayList<Song> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public boolean removeSong(String title) {
        Iterator<Song> iterator = songs.iterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();  // Remove the song if found
                return true;  // Return true if removal is successful
            }
        }
        return false;  // Return false if song not found
    }

    public void viewPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("The playlist is empty.");
        } else {
            System.out.println("Current Playlist:");
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }

    @Override
    public Iterator<Song> iterator() {
        return songs.iterator();
    }
}

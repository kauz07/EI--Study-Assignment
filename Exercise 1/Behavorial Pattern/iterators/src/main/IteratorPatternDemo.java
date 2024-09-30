package main;

import music.Playlist;
import music.Song;

import java.util.Iterator;
import java.util.Scanner;

public class IteratorPatternDemo {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Add Song  2. Remove Song  3. View Playlist  4. Play Songs  5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add song
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    playlist.addSong(new Song(title, artist));
                    System.out.println("Song added: " + title + " by " + artist);
                    break;

                case 2:
                    // Remove song
                    System.out.print("Enter song title to remove: ");
                    String songToRemove = scanner.nextLine();
                    if (playlist.removeSong(songToRemove)) {
                        System.out.println("Removed: " + songToRemove);
                    } else {
                        System.out.println("Song not found: " + songToRemove);
                    }
                    break;

                case 3:
                    // View playlist
                    playlist.viewPlaylist();
                    break;

                case 4:
                    // Play songs
                    Iterator<Song> iterator = playlist.iterator();
                    if (!iterator.hasNext()) {
                        System.out.println("No songs in the playlist to play.");
                    } else {
                        System.out.println("Playing songs one by one:");
                        while (iterator.hasNext()) {
                            Song song = iterator.next();
                            System.out.println("Now playing: " + song);
                            System.out.print("Press Enter to continue to the next song...");
                            scanner.nextLine();  // Wait for user input
                        }
                    }
                    break;

                case 5:
                    // Exit with confirmation
                    System.out.print("Are you sure you want to exit? (y/n): ");
                    String exitConfirmation = scanner.nextLine();
                    if (exitConfirmation.equalsIgnoreCase("y")) {
                        isRunning = false;
                        System.out.println("Exiting...");
                    } else {
                        System.out.println("Returning to menu...");
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}

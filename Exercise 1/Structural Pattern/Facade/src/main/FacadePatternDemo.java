package main;

import devices.DVDPlayer;
import devices.Projector;
import devices.Lights;
import devices.HomeTheaterFacade;

import java.util.Scanner;

public class FacadePatternDemo {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        Lights lights = new Lights();
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, lights);

        Scanner scanner = new Scanner(System.in);
        String choice;

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Watch Movie");
            System.out.println("2. End Movie");
            System.out.println("3. Exit");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the name of the movie: ");
                    String movie = scanner.nextLine();
                    homeTheater.watchMovie(movie);
                    break;

                case "2":
                    homeTheater.endMovie();
                    break;

                case "3":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

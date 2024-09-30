package main;

import commands.*;
import core.*;

import java.util.Scanner;

public class SatelliteCommandSystem {
    public static void main(String[] args) {
        Satellite satellite = new Satellite();
        CommandInvoker invoker = new CommandInvoker();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSatellite Command System:");
            System.out.println("1. Rotate (North, South, East, West)");
            System.out.println("2. Activate Solar Panels");
            System.out.println("3. Deactivate Solar Panels");
            System.out.println("4. Collect Data");
            System.out.println("5. Show Satellite Status");
            System.out.println("6. Exit");

            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "1":
                    System.out.print("Enter direction (North, South, East, West): ");
                    String direction = scanner.nextLine().trim();
                    invoker.executeCommand(new RotateCommand(satellite, direction));
                    break;
                case "2":
                    invoker.executeCommand(new ActivatePanelsCommand(satellite));
                    break;
                case "3":
                    invoker.executeCommand(new DeactivatePanelsCommand(satellite));
                    break;
                case "4":
                    invoker.executeCommand(new CollectDataCommand(satellite));
                    break;
                case "5":
                    satellite.displayStatus();
                    break;
                case "6":
                    System.out.println("Exiting Satellite Command System.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
        scanner.close();
    }
}

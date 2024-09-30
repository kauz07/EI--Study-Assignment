package main;

import pc.Computer;
import pc.ComputerBuilder;

import java.util.Scanner;

public class BuilderPatternDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Interactive prompts for user input
        System.out.print("Enter CPU (e.g., Intel i9, AMD Ryzen 7): ");
        String CPU = scanner.nextLine();

        System.out.print("Enter RAM (e.g., 16GB, 32GB): ");
        String RAM = scanner.nextLine();

        System.out.print("Enter Storage (e.g., 512GB SSD, 1TB HDD): ");
        String storage = scanner.nextLine();

        System.out.print("Enter GPU (e.g., NVIDIA RTX 3080, AMD RX 6800): ");
        String GPU = scanner.nextLine();

        // Building the computer with user input
        Computer computer = new ComputerBuilder()
                .setCPU(CPU)
                .setRAM(RAM)
                .setStorage(storage)
                .setGPU(GPU)
                .build();

        // Display the built computer
        System.out.println("\nYour custom-built computer is ready:");
        System.out.println(computer);

        // Option to continue building more computers
        System.out.println("\nWould you like to build another computer? (yes/no)");
        String response = scanner.nextLine();
        
        while (response.equalsIgnoreCase("yes")) {
            // Repeating the building process
            System.out.print("Enter CPU (e.g., Intel i9, AMD Ryzen 7): ");
            CPU = scanner.nextLine();

            System.out.print("Enter RAM (e.g., 16GB, 32GB): ");
            RAM = scanner.nextLine();

            System.out.print("Enter Storage (e.g., 512GB SSD, 1TB HDD): ");
            storage = scanner.nextLine();

            System.out.print("Enter GPU (e.g., NVIDIA RTX 3080, AMD RX 6800): ");
            GPU = scanner.nextLine();

            computer = new ComputerBuilder()
                    .setCPU(CPU)
                    .setRAM(RAM)
                    .setStorage(storage)
                    .setGPU(GPU)
                    .build();

            System.out.println("\nYour custom-built computer is ready:");
            System.out.println(computer);

            System.out.println("\nWould you like to build another computer? (yes/no)");
            response = scanner.nextLine();
        }

        System.out.println("Thank you for using the computer builder!");
        scanner.close();
    }
}

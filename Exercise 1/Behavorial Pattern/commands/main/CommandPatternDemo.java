package main;

import commands.TurnOnLightCommand;
import commands.TurnOffLightCommand;
import controller.SmartHomeController;
import devices.Light;

import java.util.Scanner;

public class CommandPatternDemo {

    public static void main(String[] args) {
        Light light = new Light();
        TurnOnLightCommand turnOnLightCommand = new TurnOnLightCommand(light);
        TurnOffLightCommand turnOffLightCommand = new TurnOffLightCommand(light);

        SmartHomeController controller = new SmartHomeController();

        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("1. Turn On Light  2. Turn Off Light  3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    controller.setCommand(turnOnLightCommand);
                    controller.pressButton();  // Output: Light is ON
                    break;
                case 2:
                    controller.setCommand(turnOffLightCommand);
                    controller.pressButton();  // Output: Light is OFF
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}

package main;

import furniture.Chair;
import furniture.Sofa;
import furniture.FurnitureFactory;
import furniture.FurnitureFactoryProducer;

import java.util.Scanner;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Furniture Style (GRAND/MODERN): ");
        String style = scanner.nextLine();

        FurnitureFactory factory = FurnitureFactoryProducer.getFactory(style);

        if (factory != null) {
            Chair chair = factory.createChair();
            Sofa sofa = factory.createSofa();
            chair.create();
            sofa.create();
        } else {
            System.out.println("Invalid style.");
        }
        scanner.close();
    }
}

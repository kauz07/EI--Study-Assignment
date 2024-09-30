package main;

import employees.Employee;

import java.util.Scanner;

public class CompositePatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter CEO name: ");
        String ceoName = scanner.nextLine();
        System.out.print("Enter CEO salary: ");
        double ceoSalary = scanner.nextDouble();
        scanner.nextLine();  // Consume newline left-over

        Employee CEO = new Employee(ceoName, "CEO", ceoSalary);

        while (true) {
            System.out.println("\nCompany Hierarchy Menu:");
            System.out.println("1. Add Manager to CEO");
            System.out.println("2. Add Employee to a Manager");
            System.out.println("3. Display Company Hierarchy");
            System.out.println("4. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Manager name: ");
                    String managerName = scanner.nextLine();
                    System.out.print("Enter Manager position: ");
                    String managerPosition = scanner.nextLine();
                    System.out.print("Enter Manager salary: ");
                    double managerSalary = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    Employee manager = new Employee(managerName, managerPosition, managerSalary);
                    CEO.add(manager);
                    break;

                case "2":
                    if (CEO.getSubordinates().isEmpty()) {
                        System.out.println("No managers available. Please add a manager first.");
                    } else {
                        System.out.println("Select a manager to add an employee:");
                        int i = 1;
                        for (Employee managerChoice : CEO.getSubordinates()) {
                            System.out.println(i + ". " + managerChoice);
                            i++;
                        }
                        int managerIndex = scanner.nextInt() - 1;
                        scanner.nextLine();  // Consume newline

                        if (managerIndex >= 0 && managerIndex < CEO.getSubordinates().size()) {
                            Employee selectedManager = CEO.getSubordinates().get(managerIndex);
                            System.out.print("Enter Employee name: ");
                            String employeeName = scanner.nextLine();
                            System.out.print("Enter Employee position: ");
                            String employeePosition = scanner.nextLine();
                            System.out.print("Enter Employee salary: ");
                            double employeeSalary = scanner.nextDouble();
                            scanner.nextLine();  // Consume newline

                            Employee employee = new Employee(employeeName, employeePosition, employeeSalary);
                            selectedManager.add(employee);
                        } else {
                            System.out.println("Invalid manager selection.");
                        }
                    }
                    break;

                case "3":
                    System.out.println("\nCompany Hierarchy:");
                    System.out.println(CEO);
                    for (Employee headEmployee : CEO.getSubordinates()) {
                        System.out.println(headEmployee);
                        for (Employee employee : headEmployee.getSubordinates()) {
                            System.out.println("    " + employee);
                        }
                    }
                    break;

                case "4":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

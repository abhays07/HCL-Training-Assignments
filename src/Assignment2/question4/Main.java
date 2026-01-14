package Assignment2.question4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager();
        Scanner sc = new Scanner(System.in);

        try {
            // FIRST: ADD ALL EMPLOYEES
            System.out.print("Enter number of employees to add: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details for employee " + i);

                System.out.print("Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Employee Name: ");
                String name = sc.nextLine();

                if (!EmployeeManager.isValidName(name)) {
                    throw new IllegalArgumentException("Invalid name format");
                }

                manager.addEmployee(new Employee(id, name));
            }

            int choice;

            // MENU
            do {
                System.out.println("\n----- EMPLOYEE MENU -----");
                System.out.println("1. Display All Employees");
                System.out.println("2. Search Employee by ID");
                System.out.println("3. Remove Employee by ID");
                System.out.println("4. Demonstrate Null Support");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        manager.displayEmployees();
                        break;

                    case 2:
                        System.out.print("Enter Employee ID to search: ");
                        manager.searchEmployee(sc.nextInt());
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to remove: ");
                        manager.removeEmployee(sc.nextInt());
                        break;

                    case 4:
                        manager.demonstrateNullSupport();
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 5);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

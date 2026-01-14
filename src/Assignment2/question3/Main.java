package Assignment2.question3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        try {
            // FIRST: ADD ALL STUDENTS
            System.out.print("Enter number of students to add: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details for student " + i);

                System.out.print("Roll Number: ");
                int roll = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                if (!StudentManager.isValidName(name)) {
                    throw new IllegalArgumentException("Invalid name format");
                }

                manager.addStudent(new Student(roll, name));
            }

            int choice;

            // MENU
            do {
                System.out.println("\n----- STUDENT MENU -----");
                System.out.println("1. Display All Students");
                System.out.println("2. Search Student by Roll No");
                System.out.println("3. Remove Student by Roll No");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        manager.displayStudents();
                        break;

                    case 2:
                        System.out.print("Enter Roll No to search: ");
                        manager.searchStudent(sc.nextInt());
                        break;

                    case 3:
                        System.out.print("Enter Roll No to remove: ");
                        manager.removeStudent(sc.nextInt());
                        break;

                    case 4:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 4);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

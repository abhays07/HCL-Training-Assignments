package Assignment2.question5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UniversityManager manager = new UniversityManager();
        Scanner sc = new Scanner(System.in);

        try {
            // FIRST: ADD ALL STUDENTS
            System.out.print("Enter number of students to add: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details for student " + i);

                System.out.print("Student ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                if (!UniversityManager.isValidName(name))
                    throw new IllegalArgumentException("Invalid name format");

                System.out.print("Course: ");
                String course = sc.nextLine();

                System.out.print("Marks: ");
                int marks = sc.nextInt();

                manager.addStudent(new Student(id, name, course, marks));
            }

            int choice;

            // MENU
            do {
                System.out.println("\n----- UNIVERSITY MENU -----");
                System.out.println("1. Display All Students");
                System.out.println("2. Search Student by ID");
                System.out.println("3. Remove Student by ID");
                System.out.println("4. Sort Students by Marks");
                System.out.println("5. Convert HashMap to TreeMap");
                System.out.println("6. Count Students Course-wise");
                System.out.println("7. Display Unique Courses");
                System.out.println("8. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> manager.displayStudents();
                    case 2 -> {
                        System.out.print("Enter ID to search: ");
                        manager.searchStudent(sc.nextInt());
                    }
                    case 3 -> {
                        System.out.print("Enter ID to remove: ");
                        manager.removeStudent(sc.nextInt());
                    }
                    case 4 -> manager.sortByMarks();
                    case 5 -> manager.convertToTreeMap();
                    case 6 -> manager.countCourseWise();
                    case 7 -> manager.displayCourses();
                    case 8 -> System.out.println("Exiting program...");
                    default -> System.out.println("Invalid choice!");
                }

            } while (choice != 8);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

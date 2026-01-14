package Assignment2.question2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexValidation {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- REGEX VALIDATION MENU ---");
            System.out.println("1. Validate Mobile Number");
            System.out.println("2. Validate Email ID");
            System.out.println("3. Validate Username");
            System.out.println("4. Validate Password");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1 -> validate(
                        "Enter Mobile Number: ",
                        "^[6-9]\\d{9}$",
                        "Mobile Number"
                );

                case 2 -> validate(
                        "Enter Email ID: ",
                        "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",
                        "Email ID"
                );

                case 3 -> validate(
                        "Enter Username: ",
                        "^[a-zA-Z0-9_]{5,15}$",
                        "Username"
                );

                case 4 -> validate(
                        "Enter Password: ",
                        "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%!]).{8,}$",
                        "Password"
                );

                case 5 -> System.out.println("Exiting program...");

                default -> System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }

    private static void validate(String prompt, String regex, String fieldName) {

        System.out.print(prompt);
        String input = sc.nextLine();

        if (Pattern.matches(regex, input)) {
            System.out.println("Welcome! Valid " + fieldName);
        } else {
            System.out.println("Invalid " + fieldName + ". Please try again.");
        }
    }
}

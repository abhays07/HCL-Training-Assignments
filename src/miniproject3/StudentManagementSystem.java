package miniproject3;

import java.io.*;
import java.util.*;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static final String FILE = "students.dat";

    // ---------------- FILE HANDLING ----------------
    static void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (Exception e) {
            students = new ArrayList<>();
        }
    }

    static void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(students);
        } catch (Exception e) {
            System.out.println("File Error");
        }
    }

    // ---------------- LOGIN ----------------
    static boolean login() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();
        return u.equals("admin") && p.equals("admin123");
    }

    // ---------------- VALIDATION ----------------
    static boolean enoExists(int eno) {
        for (Student s : students)
            if (s.getEno() == eno)
                return true;
        return false;
    }

    // ---------------- MENU FUNCTIONS ----------------
    static void addStudent() {
        try {
            System.out.print("Enter Eno: ");
            int eno = sc.nextInt();

            if (enoExists(eno))
                throw new Exception("Eno must be unique");

            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Branch: ");
            String branch = sc.nextLine();
            if (branch.isEmpty())
                throw new Exception("Branch cannot be empty");

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            System.out.print("Percentage: ");
            double per = sc.nextDouble();
            if (per <= 0)
                throw new Exception("Percentage must be positive");

            students.add(new Student(eno, name, branch, sem, per));
            save();
            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }
    }

    static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No Records Found");
            return;
        }
        for (Student s : students)
            System.out.println(s);
    }

    static void searchByEno() {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.getEno() == eno) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    static void updateBranch() {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getEno() == eno) {
                System.out.print("New Branch: ");
                String branch = sc.nextLine();
                if (branch.isEmpty()) {
                    System.out.println("Branch cannot be empty");
                    return;
                }
                s.setBranch(branch);
                save();
                System.out.println("Branch Updated");
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    static void deleteStudent() {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getEno() == eno) {
                it.remove();
                save();
                System.out.println("Student Deleted");
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    static void displaySorted() {
        Collections.sort(students);
        displayAll();
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        load();

        if (!login()) {
            System.out.println("Invalid Login");
            return;
        }

        while (true) {
            System.out.println("\n1.Add Student");
            System.out.println("2.Display All Students");
            System.out.println("3.Search Student by Eno");
            System.out.println("4.Update Student Branch");
            System.out.println("5.Delete Student by Eno");
            System.out.println("6.Display Sorted Students");
            System.out.println("7.Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> addStudent();
                case 2 -> displayAll();
                case 3 -> searchByEno();
                case 4 -> updateBranch();
                case 5 -> deleteStudent();
                case 6 -> displaySorted();
                case 7 -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }
        }
    }
}

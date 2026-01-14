package Assignment2.question3;

import java.util.*;
import java.util.regex.Pattern;

public class StudentManager implements StudentOperations {

    List<Student> studentList = new ArrayList<>();
    Vector<Student> studentVector = new Vector<>();

    @Override
    public void addStudent(Student s) {
        studentList.add(s);
        studentVector.add(s);
        System.out.println("Student added successfully.");
    }

    @Override
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    @Override
    public void searchStudent(int rollNo) {
        for (Student s : studentList) {
            if (s.getRollNo() == rollNo) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    @Override
    public void removeStudent(int rollNo) {
        boolean removed = studentList.removeIf(s -> s.getRollNo() == rollNo);
        studentVector.removeIf(s -> s.getRollNo() == rollNo);

        if (removed)
            System.out.println("Student removed successfully.");
        else
            System.out.println("Student not found.");
    }

    // REGEX validation
    public static boolean isValidName(String name) {
        return Pattern.matches("^[A-Za-z ]+$", name);
    }
}

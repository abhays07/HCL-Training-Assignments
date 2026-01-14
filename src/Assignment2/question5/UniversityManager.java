package Assignment2.question5;

import java.util.*;
import java.util.regex.Pattern;

public class UniversityManager implements UniversityOperations {

    // Collections
    List<Student> studentList = new ArrayList<>();
    Vector<Student> studentVector = new Vector<>();
    Stack<Student> studentStack = new Stack<>();
    Set<String> courseSet = new HashSet<>();

    HashMap<Integer, Student> studentMap = new HashMap<>();
    Hashtable<Integer, Student> studentTable = new Hashtable<>();

    // Add Student
    @Override
    public void addStudent(Student s) {
        if (studentMap.containsKey(s.getId())) {
            throw new RuntimeException("Duplicate Student ID not allowed");
        }

        studentList.add(s);
        studentVector.add(s);
        studentStack.push(s);
        studentMap.put(s.getId(), s);
        studentTable.put(s.getId(), s);
        courseSet.add(s.getCourse());

        System.out.println("Student added successfully.");
    }

    @Override
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        studentList.forEach(System.out::println);
    }

    @Override
    public void searchStudent(int id) {
        Student s = studentMap.get(id);
        if (s != null)
            System.out.println("Student Found: " + s);
        else
            System.out.println("Student not found.");
    }

    @Override
    public void removeStudent(int id) {
        if (studentMap.containsKey(id)) {
            studentList.removeIf(s -> s.getId() == id);
            studentVector.removeIf(s -> s.getId() == id);
            studentMap.remove(id);
            studentTable.remove(id);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Sort students by marks
    public void sortByMarks() {
        studentList.sort(Comparator.comparingInt(Student::getMarks));
        System.out.println("Students sorted by marks.");
    }

    // Convert HashMap to TreeMap
    public void convertToTreeMap() {
        TreeMap<Integer, Student> treeMap = new TreeMap<>(studentMap);
        treeMap.values().forEach(System.out::println);
    }

    // Count students course-wise
    public void countCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();
        for (Student s : studentList) {
            countMap.put(s.getCourse(),
                    countMap.getOrDefault(s.getCourse(), 0) + 1);
        }
        System.out.println(countMap);
    }

    // Display unique courses
    public void displayCourses() {
        courseSet.forEach(System.out::println);
    }

    // REGEX validation
    public static boolean isValidName(String name) {
        return Pattern.matches("^[A-Za-z ]+$", name);
    }
}

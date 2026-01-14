package Assignment2.question4;

import java.util.*;
import java.util.regex.Pattern;

public class EmployeeManager implements EmployeeOperations {

    HashMap<Integer, Employee> hashMap = new HashMap<>();
    Hashtable<Integer, Employee> hashtable = new Hashtable<>();
    TreeMap<Integer, Employee> treeMap = new TreeMap<>();

    @Override
    public void addEmployee(Employee e) {
        hashMap.put(e.getId(), e);
        hashtable.put(e.getId(), e);
        treeMap.put(e.getId(), e);
        System.out.println("Employee added successfully.");
    }

    @Override
    public void displayEmployees() {
        if (hashMap.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        hashMap.values().forEach(System.out::println);
    }

    @Override
    public void searchEmployee(int id) {
        Employee e = hashMap.get(id);
        if (e != null)
            System.out.println("Employee Found: " + e);
        else
            System.out.println("Employee not found.");
    }

    @Override
    public void removeEmployee(int id) {
        if (hashMap.remove(id) != null) {
            hashtable.remove(id);
            treeMap.remove(id);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Demonstrate null support
    public void demonstrateNullSupport() {
        System.out.println("\n--- Null Support Demonstration ---");

        // HashMap allows null
        hashMap.put(null, new Employee(0, "NULL_KEY"));
        hashMap.put(999, null);

        System.out.println("HashMap allows ONE null key and multiple null values.");

        // Hashtable & TreeMap DO NOT allow null
        System.out.println("Hashtable and TreeMap do NOT allow null key or value.");
    }

    // REGEX validation
    public static boolean isValidName(String name) {
        return Pattern.matches("^[A-Za-z ]+$", name);
    }
}

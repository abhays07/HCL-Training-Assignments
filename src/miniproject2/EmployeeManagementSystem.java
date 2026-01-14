package miniproject2;
import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {

    static final String FILE = "employees.dat";
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();

    static void load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE));
            employees = (ArrayList<Employee>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            employees = new ArrayList<>();
        }
    }

    static void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
            oos.writeObject(employees);
            oos.close();
        } catch (Exception e) {
            System.out.println("File Error");
        }
    }

    static boolean idExists(int id) {
        for (Employee e : employees)
            if (e.id == id)
                return true;
        return false;
    }

    static void addEmployee() {
        System.out.print("Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (idExists(id)) {
            System.out.println("ID already exists");
            return;
        }

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String dept = sc.nextLine();
        if (dept.isEmpty()) {
            System.out.println("Department cannot be empty");
            return;
        }

        System.out.print("Salary: ");
        double salary = sc.nextDouble();
        if (salary <= 0) {
            System.out.println("Salary must be positive");
            return;
        }

        employees.add(new Employee(id, name, dept, salary));
        save();
        System.out.println("Employee Added");
    }

    static void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No Records");
            return;
        }
        for (Employee e : employees)
            System.out.println(e);
    }

    static void searchById() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    static void updateSalary() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.print("New Salary: ");
                double sal = sc.nextDouble();
                if (sal <= 0) {
                    System.out.println("Salary must be positive");
                    return;
                }
                e.salary = sal;
                save();
                System.out.println("Salary Updated");
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    static void deleteEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) {
                it.remove();
                save();
                System.out.println("Employee Deleted");
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    static void displaySorted() {
        Collections.sort(employees);
        displayAll();
    }

    static void displayDepartments() {
        HashSet<String> depts = new HashSet<>();
        for (Employee e : employees)
            depts.add(e.department);

        for (String d : depts)
            System.out.println(d);
    }

    static boolean login() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        return u.equals("admin") && p.equals("admin123");
    }

    public static void main(String[] args) {

        load();

        if (!login()) {
            System.out.println("Invalid Login");
            return;
        }

        while (true) {
            System.out.println("\n1.Add Employee");
            System.out.println("2.Display All Employees");
            System.out.println("3.Search Employee by ID");
            System.out.println("4.Update Employee Salary");
            System.out.println("5.Delete Employee");
            System.out.println("6.Display Sorted Employees");
            System.out.println("7.Display Departments");
            System.out.println("8.Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> addEmployee();
                case 2 -> displayAll();
                case 3 -> searchById();
                case 4 -> updateSalary();
                case 5 -> deleteEmployee();
                case 6 -> displaySorted();
                case 7 -> displayDepartments();
                case 8 -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }
        }
    }
}
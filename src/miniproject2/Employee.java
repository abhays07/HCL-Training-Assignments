package miniproject2;

import java.io.*;
import java.util.*;

class Employee implements Serializable, Comparable<Employee> {

    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int compareTo(Employee e) {
        return this.id - e.id;
    }

    public String toString() {
        return id + "  " + name + "  " + department + "  " + salary;
    }
}
package Assignment3;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {

        // Constructors
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(10);
        ArrayList<String> temp = new ArrayList<>();
        temp.add("A");
        temp.add("B");
        ArrayList<String> list3 = new ArrayList<>(temp);

        // Methods
        list1.add("Java");
        list1.add("Python");
        list1.add(1, "C++");
        list1.addAll(list3);
        list1.addAll(2, temp);

        System.out.println(list1);

        list1.remove("Java");
        list1.remove(0);

        System.out.println(list1.get(1));
        list1.set(1, "Spring");

        System.out.println(list1.contains("Spring"));
        System.out.println(list1.indexOf("Spring"));
        System.out.println(list1.lastIndexOf("Spring"));

        System.out.println(list1.size());
        System.out.println(list1.isEmpty());

        Object[] arr = list1.toArray();
        System.out.println(Arrays.toString(arr));

        list1.clear();
        System.out.println(list1);
    }
}

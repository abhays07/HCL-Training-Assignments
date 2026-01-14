package Assignment3;

import java.util.*;

public class HashtableDemo {
    public static void main(String[] args) {

        Hashtable<Integer, String> ht1 = new Hashtable<>();
        Hashtable<Integer, String> ht2 = new Hashtable<>(10);
        Hashtable<Integer, String> ht3 = new Hashtable<>(10, 0.75f);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        Hashtable<Integer, String> ht4 = new Hashtable<>(map);

        ht1.put(101, "Java");
        ht1.put(102, "Python");
        ht1.putIfAbsent(103, "C++");

        System.out.println(ht1);

        ht1.remove(101);
        System.out.println(ht1.get(102));

        System.out.println(ht1.containsKey(103));
        System.out.println(ht1.containsValue("Python"));

        System.out.println(ht1.keys());
        System.out.println(ht1.elements());

        System.out.println(ht1.keySet());
        System.out.println(ht1.values());
        System.out.println(ht1.entrySet());

        System.out.println(ht1.size());
        System.out.println(ht1.isEmpty());

        ht1.clear();
        System.out.println(ht1);
    }
}

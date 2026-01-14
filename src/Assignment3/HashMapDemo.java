package Assignment3;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>(10);
        HashMap<Integer, String> map3 = new HashMap<>(10, 0.75f);

        Map<Integer, String> temp = new HashMap<>();
        temp.put(1, "One");
        HashMap<Integer, String> map4 = new HashMap<>(temp);

        map1.put(101, "Java");
        map1.put(102, "Python");
        map1.putIfAbsent(103, "C++");

        map1.putAll(map4);

        System.out.println(map1);

        map1.remove(101);
        map1.remove(102, "Python");

        System.out.println(map1.get(103));
        System.out.println(map1.containsKey(1));
        System.out.println(map1.containsValue("One"));

        System.out.println(map1.keySet());
        System.out.println(map1.values());
        System.out.println(map1.entrySet());

        System.out.println(map1.size());
        System.out.println(map1.isEmpty());

        map1.clear();
        System.out.println(map1);
    }
}

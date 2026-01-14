package Assignment3;

import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {

        TreeMap<Integer, String> tm1 = new TreeMap<>();
        TreeMap<Integer, String> tm2 = new TreeMap<>(Comparator.reverseOrder());

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        TreeMap<Integer, String> tm3 = new TreeMap<>(map);

        SortedMap<Integer, String> sm = new TreeMap<>();
        sm.put(2, "Two");
        TreeMap<Integer, String> tm4 = new TreeMap<>(sm);

        tm1.put(10, "Java");
        tm1.put(20, "Python");
        tm1.put(15, "C++");

        System.out.println(tm1);

        tm1.remove(20);
        System.out.println(tm1.get(10));

        System.out.println(tm1.firstKey());
        System.out.println(tm1.lastKey());

        System.out.println(tm1.headMap(15));
        System.out.println(tm1.tailMap(15));
        System.out.println(tm1.subMap(10, 20));

        System.out.println(tm1.ceilingKey(12));
        System.out.println(tm1.floorKey(12));

        System.out.println(tm1.keySet());
        System.out.println(tm1.values());
        System.out.println(tm1.entrySet());

        System.out.println(tm1.size());
        tm1.clear();
        System.out.println(tm1);
    }
}

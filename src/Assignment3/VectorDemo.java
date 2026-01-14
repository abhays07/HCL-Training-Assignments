package Assignment3;

import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {

        Vector<Integer> v1 = new Vector<>();
        Vector<Integer> v2 = new Vector<>(5);
        Vector<Integer> v3 = new Vector<>(5, 3);

        List<Integer> list = Arrays.asList(10, 20);
        Vector<Integer> v4 = new Vector<>(list);

        v1.add(1);
        v1.addElement(2);
        v1.add(3);
        v1.insertElementAt(4, 1);
        v1.addAll(v4);

        System.out.println(v1);

        v1.remove(0);
        v1.removeElement(20);
        v1.removeElementAt(1);

        System.out.println(v1.elementAt(0));
        System.out.println(v1.firstElement());
        System.out.println(v1.lastElement());

        System.out.println(v1.contains(10));
        System.out.println(v1.capacity());
        System.out.println(v1.size());

        v1.clear();
        System.out.println(v1);
    }
}

package assignment1;
import java.util.*;

class StringOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(s.length());
        System.out.println(s.isEmpty());
        System.out.println(s.charAt(0));
        System.out.println(s.toString());
        System.out.println(s.equals(t));
        System.out.println(s.compareTo(t));
        System.out.println(s.contains(t));
        System.out.println(s.indexOf(t));
        System.out.println(s.lastIndexOf(t));
        System.out.println(s.startsWith(t));
        System.out.println(s.endsWith(t));
        System.out.println(s.matches(".*"));
        System.out.println(s.substring(0,1));
        System.out.println(s.toLowerCase());
        System.out.println(s.trim());
        System.out.println(s.replace("a","b"));
        System.out.println(Arrays.toString(s.split(" ")));
        System.out.println(String.join("-", s, t));
        System.out.println(String.valueOf(1));

        StringBuffer sb = new StringBuffer(s);
        StringBuilder sd = new StringBuilder(s);
        System.out.println(sb.append(t));
        System.out.println(sd.reverse());
    }
}

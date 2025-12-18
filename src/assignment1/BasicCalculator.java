package assignment1;

import java.util.Scanner;

public class BasicCalculator {
	  	public static double add(double x, double y) {
	  		return x + y; 
	  	}
	    public static double subtract(double x, double y) {
	    	return x - y; 
	    }
	    public static double multiply(double x, double y) {
	    	return x * y; 
	    }
	    public static double divide(double x, double y) {
	    	return y != 0 ? x / y : 0; 
	    }
	    public static double remainder(double x, double y) {
	    	return x % y; 
	    }
	    public static double square(double x) {
	    	return x * x; 
	    }
	    public static double cube(double x) {
	    	return x * x * x; 
	    }
	    public static double absolute(double x) {
	    	return Math.abs(x); 
	    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner (System.in);
    	double a = sc.nextDouble();
    	double b = sc.nextDouble();
    	sc.close();
        System.out.println("Addition: " + add(a, b));
        System.out.println("Subtraction: " + subtract(a, b));
        System.out.println("Multiplication: " + multiply(a, b));
        System.out.println("Division: " + divide(a, b));
        System.out.println("Remainder: " + remainder(a, b));
        System.out.println("Square of " + a + ": " + square(a));
        System.out.println("Cube of " + a + ": " + cube(a));
        System.out.println("Absolute of -50: " + absolute(-50));
    }

  
}

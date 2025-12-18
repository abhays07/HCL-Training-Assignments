package assignment1;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int size = 0;

        while (true) {
            System.out.println("\n--- Array Menu ---");
            System.out.println("1. Insert  2. Delete  3. Linear Search  4. Binary Search");
            System.out.println("5. Max Value  6. Count Even/Odd  7. Insertion Sort  8. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    arr[size++] = sc.nextInt();
                    break;
                case 2:
                    size--; // Simple deletion of last element
                    System.out.println("Last element removed.");
                    break;
                case 3:
                    System.out.print("Enter target: ");
                    int target = sc.nextInt();
                    int index = -1;
                    for(int i=0; i<size; i++) if(arr[i] == target) index = i;
                    System.out.println("Found at index: " + index);
                    break;
                case 4:
                    Arrays.sort(arr, 0, size);
                    System.out.print("Enter target: ");
                    int bTarget = sc.nextInt();
                    System.out.println("Binary Search Result: " + Arrays.binarySearch(arr, 0, size, bTarget));
                    break;
                case 5:
                    int max = arr[0];
                    for(int i=1; i<size; i++) if(arr[i] > max) max = arr[i];
                    System.out.println("Max: " + max);
                    break;
                case 6:
                    int e = 0, o = 0;
                    for(int i=0; i<size; i++) if(arr[i]%2 == 0) e++; else o++;
                    System.out.println("Even: " + e + ", Odd: " + o);
                    break;
                case 7:
                    insertionSort(arr, size);
                    System.out.println("Array sorted.");
                    break;
                case 8: System.exit(0);
            }
        }
    }

    public static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; ++i) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }
}

package at.technikum.week5;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayEvenStatistics {
    private static ArrayList<Integer> evenNumbers = new ArrayList<>();
    private static ArrayList<Integer> indexes = new ArrayList<>();
    private static int maxValue = Integer.MIN_VALUE;
    private static int sum = 0;
    private static ArrayList<Integer> maxValueIndexes = new ArrayList<>();

    public static ArrayList<Integer> getReturnInput () {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter numbers:");
        while (sc.hasNext()) {
            int inp = sc.nextInt();
            boolean quit = false;
            if (inp == 0) {
                System.out.println("re-enter 0 to store as value");
                int secInp = sc.nextInt();
                if (secInp == 0) {
                    arr.add(0);
                } else {
                    quit = true;
                }
            } else {
                arr.add(inp);
            }
            if (quit) break;
        }
        return arr;
    }

    public static void output (ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            System.out.println("no values entered");
            return;
        };

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 == 0) {
                evenNumbers.add(arr.get(i));
                sum += arr.get(i);
                indexes.add(i);
                if (arr.get(i) >= maxValue) {
                    maxValue = arr.get(i);
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == maxValue) {
                maxValueIndexes.add(i);
            }
        }

        System.out.println("Number of even numbers stored: " + evenNumbers.size());
        System.out.println("Index positions of the even numbers:");
        for (int i : indexes) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.println("Sum of the even numbers: " + sum);
        System.out.printf("Mean of the even numbers: %.2f %n", ((double)sum / (double) evenNumbers.size()));
        System.out.println("Value of the maximum even number: " + maxValue);
        System.out.println("(all) index position(s) of the maximum even number:");
        for (int i : maxValueIndexes) {
            System.out.print(" " + i);
        }

    }

    public static void run () {
        ArrayList<Integer> arr = getReturnInput();
        output(arr);
    }
}

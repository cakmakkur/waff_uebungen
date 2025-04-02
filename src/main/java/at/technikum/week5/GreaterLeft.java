package at.technikum.week5;

import java.util.ArrayList;
import java.util.Scanner;

public class GreaterLeft {
    private static final Scanner sc = new Scanner(System.in);

    private static int[] getReturnInput () {
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    private static void process (int[] arr) {
        System.out.print("[0");
        for (int i = 1; i < arr.length; i++) {
            int a = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    a++;
                }
            }
            System.out.print(", " + a);
        }
        System.out.print("]");
    }


    public static void run () {
        process(getReturnInput());
    }
}

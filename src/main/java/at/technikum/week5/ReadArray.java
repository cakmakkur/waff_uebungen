package at.technikum.week5;

import java.util.Scanner;

public class ReadArray {
    public static void run () {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 10 numbers");
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Input finished");
        for (int i = 9; i >= 0; i--) {
            System.out.println("[" + i + "]: " + arr[i]);
        }
        System.out.println("Output finished");
    }
}

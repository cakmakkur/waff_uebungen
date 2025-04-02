package at.technikum.week4;

import java.util.Arrays;
import java.util.Scanner;

public class IntervalleSchliessen {
    public IntervalleSchliessen () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two sets of interval values:");
        int[] arr1 = new int[2], arr2 = new int[2];
        for (int i = 0; i < 2; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            arr2[i] = sc.nextInt();
        }
        sc.close();

        System.out.println("Grenze 1: " + arr1[0]);
        System.out.println("Grenze 2: " + arr1[1]);
        System.out.println("Grenze 1: " + arr2[0]);
        System.out.println("Grenze 2: " + arr2[1]);
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("Intervall 1: [" +arr1[0]+", "+arr1[1]+"]");
        System.out.println("Intervall 2: [" +arr2[0]+", "+arr2[1]+"]");
        System.out.println("geschlossenes Intervall: [" + Math.min(arr1[0], arr2[0]) + ", " + Math.max(arr1[1], arr2[1]) + "]");
    }
}

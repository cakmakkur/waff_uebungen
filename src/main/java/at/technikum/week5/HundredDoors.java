package at.technikum.week5;

import java.util.Scanner;

public class HundredDoors {
    public static void run () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of doors:");
        int num = sc.nextInt();
        sc.close();
        boolean[] doors = new boolean[num];

        for (int i = 0; i < num; i++) {
            for (int j = i; j < num; j += (i+1)) {
                doors[j] = !doors[j];
            }
        }

        System.out.println("Open doors are: ");
        for (int i = 0; i < num; i++) {
            if (doors[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}

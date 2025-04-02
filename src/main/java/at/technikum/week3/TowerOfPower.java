package at.technikum.week3;

import java.util.Scanner;

public class TowerOfPower {
    public TowerOfPower () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base between 1 and 10: ");
        int base = sc.nextInt();
        if (base < 1 || base > 10) {
            System.out.println("Invalid entry.");
            return;
        }
        System.out.printf("%8d%n", base);
        for (int i = 2; i < 8; i++) {
            System.out.printf("%8d%n", (int) Math.pow(base, i));
        }
    }
}

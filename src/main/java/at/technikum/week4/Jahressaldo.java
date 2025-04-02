package at.technikum.week4;

import java.util.Scanner;

public class Jahressaldo {
    public Jahressaldo () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Monatssalden:");

        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        double jahresS = 0;
        double[] arr = new double[12];

        for (int i = 0; i < 12; i++) {
            System.out.println("Monat " + (i + 1) + ":");
            arr[i] = sc.nextDouble();
            if (arr[i] > highest) {
                highest = arr[i];
            } else if (arr[i] < lowest) {
                lowest = arr[i];
            }
        }

        // jahressaldo
        for (double d : arr) {
            jahresS += d;
        }

        // print them
        for (int i = 0; i < 12; i++) {
            System.out.println("Monat " + (i + 1) + ": " + arr[i]);
            if (arr[i] == 0) {
                System.out.println("Nullsummenspiel");
            }
        }

        System.out.println("Jahressaldo: " + jahresS);
        System.out.println("Groesster Saldo: " + highest);
        System.out.println("Niedrigster Saldo: " + lowest);
    }
}

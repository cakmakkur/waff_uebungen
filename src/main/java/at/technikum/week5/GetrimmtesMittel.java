package at.technikum.week5;

import java.util.Scanner;

public class GetrimmtesMittel {
    public static final int ARRAY_SIZE = 10;
    public static final double[] arr = new double[ARRAY_SIZE];

    public static int trim(double[] betraege, double min, double max) {
        if (min < 0 || max > ARRAY_SIZE) return -1;
        int trimmed = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (i < min - 1 || i > max - 1) {
                trimmed++;
                betraege[i] = 0;
            }
            if (i == min - 1) {
                System.out.println("Min trim value: " + betraege[i]);
            }
            if (i == max - 1) {
                System.out.println("Max trim value: " + betraege[i]);
            }
        }
        return trimmed;
    }

    public static void eingabe(double[] betraege) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            betraege[i] = sc.nextDouble();
        }
        sc.close();
    }

    public static double sum(double[] betraege) {
        double total = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            total += betraege[i];
        }
        return total;
    }
}

/*        int ARRAY_SIZE = GetrimmtesMittel.ARRAY_SIZE;
        double[] arr = GetrimmtesMittel.arr;
        System.out.println("Enter " + ARRAY_SIZE + " values: ");
        GetrimmtesMittel.eingabe(arr);
        System.out.println("Ungetrimmtes Mittel: " + GetrimmtesMittel.sum(arr));
        System.out.println("Trim values: 4 and 9");
        GetrimmtesMittel.trim(arr, 4, 9);
        System.out.println("Getrimmtes Mittel: " + GetrimmtesMittel.sum(arr));*/
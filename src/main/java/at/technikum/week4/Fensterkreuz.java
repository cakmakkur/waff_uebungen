package at.technikum.week4;

import java.util.Scanner;

public class Fensterkreuz {
    private int b, h, x, y;
    private int dotCount = 0;

    public Fensterkreuz() {
        getUserInput();

        for (int i = 0; i < h; i++) {
            char[] arr = new char[b];
            for (int j = 0; j < b; j++) {
                if (j == x - 1) {
                    arr[j] = '|';
                } else if (i == y - 1) {
                    arr[j] = '-';
                } else {
                    arr[j] = '.';
                    dotCount++;
                }
            }
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println(dotCount + " dot(s)");
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib Breite ein:");
        b = sc.nextInt();
        while (b <= 0) {
            System.out.println("Breite muss höher als 0 sein. Erneut versuchen:");
            b = sc.nextInt();
        }
        System.out.println("Gib Höhe ein:");
        h = sc.nextInt();
        while (h <= 0) {
            System.out.println("Höhe muss höher als 0 sein. Erneut versuchen:");
            h = sc.nextInt();
        }
        System.out.println("Gib horizontale Position vom Fensterkreuz ein:");
        x = sc.nextInt();
        while (x > b || x < 1) {
            System.out.println("Außerhalb der Grenze. Erneut versuchen:");
            x = sc.nextInt();
        }
        System.out.println("Gib vertikale Position vom Fensterkreuz ein:");
        y = sc.nextInt();
        while (y > h || y < 1) {
            System.out.println("Außerhalb der Grenze. Erneut versuchen:");
            y = sc.nextInt();
        }
    }
}

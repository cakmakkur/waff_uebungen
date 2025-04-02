package at.technikum.week4;

import java.util.Scanner;

public class Diagonale {
    public Diagonale () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib die Seitenlänge des Quadrates ein. Nur ungerade Zahlen sind akzeptiert");
        int l = sc.nextInt();
        while (l < 3 || l % 2 == 0) {
            System.out.println("Falsche Eingabe. Erneut versuchen:");
            l = sc.nextInt();
        }

        for (int i = 0; i < l; i++) {
            char[] arr = new char[l];

            for (int j = 0; j < l; j++) {
                if (i == j || (l-j -1) == i) {
                    arr[j] = '*';
                } else {
                    arr[j] = '-';
                }
            }

            for(char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

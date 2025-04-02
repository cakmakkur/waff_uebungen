package at.technikum.week4;

import java.util.Scanner;

public class MalReihe {
    Scanner sc = new Scanner(System.in);
    private int fix, grenze;

    public MalReihe () {
        getUserInput();

        System.out.println("Fixfaktor: " + fix);
        System.out.println("Grenzfaktor: " + grenze);
        for (int i = 0; i < grenze; i++) {
            System.out.println((i+1) + " x " + fix + " = " + (fix * (i + 1)));
        }

    }

    private void getUserInput () {
        System.out.println("Gib den Fixfaktor ein:");
        fix = sc.nextInt();
        while (fix < -10 || fix > 10) {
            System.out.println("Außerhalb der Grenze. Erneut versuchen:");
            fix = sc.nextInt();
        }

        System.out.println("Gib den Grenzfaktor ein:");
        grenze = sc.nextInt();
        while (grenze < 1 || grenze > 10) {
            System.out.println("Außerhalb der Grenze. Erneut versuchen:");
            grenze = sc.nextInt();
        }
    }
}

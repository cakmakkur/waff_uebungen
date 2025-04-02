package at.technikum.LearningStuff;

import java.util.Scanner;

// this was created for the tests...

public class SomeCodeForTesting {

    public static boolean m1(int i) {
        if (i == 1) return true;
        return false;
    }

    public static String returnEnteredTest() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static char calculateGrade(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Grade can't be lower than 0");
        }
        if (i < 60) {
            return 'F';
        }
        if (i < 80) {
            return 'B';
        }
        return 'A';
    }

    public static String handleUserInput() {
        Scanner sc = new Scanner(System.in);
        return "User typed: " + sc.next();
    }

    public static boolean isEven(int i) {
        return i % 2 == 0;
    }
}

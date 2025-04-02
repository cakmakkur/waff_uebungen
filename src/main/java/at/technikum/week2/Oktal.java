package at.technikum.week2;

import java.util.*;

public class Oktal {
    Scanner sc = new Scanner(System.in);

    private int octalToDecimal (int oct) {
        String octString = String.valueOf(oct);
        Deque<Integer> deq = new ArrayDeque<>();
        int currentPos = 0;
        int decimal = 0;
        for (int i = 0; i < octString.length(); i++) {
            deq.addLast(Character.getNumericValue(octString.charAt(i)));
        }
        while (!deq.isEmpty()) {
            decimal += deq.removeLast() * (int) Math.pow(8, currentPos);
            currentPos++;
        }
        return decimal;
    }

    private int decimalSum (int dec) {
        String dezString = String.valueOf(dec);
        int sum = 0;
        for (int i = 0; i < dezString.length(); i++) {
            sum += Character.getNumericValue(dezString.charAt(i));
        }
        return sum;
    }

    public void run () {
        System.out.println("Type an octal number");

        int dezimal = octalToDecimal(sc.nextInt());
        System.out.println("dezimal: " + dezimal);

        int zifferSumme = decimalSum(dezimal);
        System.out.println("ziffersumme: " + zifferSumme);

    }

}

// chatGPT Lösung:
/*
package at.technikum.week2;

import java.util.Scanner;

public class Oktal {
    Scanner sc = new Scanner(System.in);

    private int octalToDecimal(int oct) {
        return Integer.parseInt(String.valueOf(oct), 8);
    }

    private int decimalSum(int dec) {
        int sum = 0;
        while (dec > 0) {
            sum += dec % 10;
            dec /= 10;
        }
        return sum;
    }

    public void run() {
        System.out.println("Type an octal number");

        int decimal = octalToDecimal(sc.nextInt());
        System.out.println("dezimal: " + decimal);

        int digitSum = decimalSum(decimal);
        System.out.println("ziffersumme: " + digitSum);
    }
} */

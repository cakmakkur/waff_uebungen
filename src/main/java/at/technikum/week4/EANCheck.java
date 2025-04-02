package at.technikum.week4;

import java.util.Scanner;

public class EANCheck {
    public EANCheck() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter EAN");
        char[] eanCharArr = sc.next().toCharArray();
        sc.close();

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < eanCharArr.length - 1; i++) {
            if (i % 2 == 0) {
                //odd
                oddSum += Character.getNumericValue(eanCharArr[i]);
            } else {
                evenSum += Character.getNumericValue(eanCharArr[i]);
            }
        }
        int checkSum = 9 - ((((evenSum * 3) + oddSum) - 1) % 10);

        if (checkSum == Character.getNumericValue(eanCharArr[eanCharArr.length - 1])) {
            System.out.println("The EAN is VALID.");
        } else {
            System.out.println("The EAN is NOT VALID.");
        }


    }
}

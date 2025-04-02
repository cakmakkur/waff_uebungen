package at.technikum.week4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Noten {
    int input;
    char[] charArr;
    Scanner sc = new Scanner(System.in);


    public Noten () {
        System.out.println("Geben Sie 3 Noten als eine einzige 3-stellige Zahl ein:");
        checkIfValidInput();
        // check if all 1
        boolean allEinser = false;
        for (char n : charArr) {
            if (Character.getNumericValue(n) == 1) {
                allEinser = true;
            } else {
                allEinser = false;
                break;
            }
        }
        if (allEinser) {
            System.out.println("Noten: " + input);
            System.out.println("Ausgezeichneter Erfolg!");
            return;
        }

        // check if failed
        for (char n : charArr) {
            if (Character.getNumericValue(n) == 5) {
                System.out.println("Noten: " + input);
                System.out.println("Nicht bestanden!");
                return;
            }
        }
        // check if 1 + 1 + 2
        int sum = 0;
        for (char n : charArr) {
            sum += Character.getNumericValue(n);
        }
        if (sum == 4) {
            System.out.println("Noten: " + input);
            System.out.println("Guter Erfolg!");
            return;
        }
        // default: Bestanden.
        System.out.println("Noten: " + input);
        System.out.println("Bestanden.");
    }

    private void checkIfValidInput () {
        boolean correctEntry = false;
        while (!correctEntry) {
            try {
                //check if number -- turn to positive if negative
                input = Math.abs(sc.nextInt());
                //check if 3 digits
                if (String.valueOf(input).length() != 3) {
                    System.out.println("Erwarte genau 3 Noten! Erneut Versuchen:");
                    continue;
                }
                //check if between 1 - 5
                charArr = String.valueOf(input).toCharArray();
                if (Character.getNumericValue(charArr[0]) < 1 || Character.getNumericValue(charArr[0]) > 5) {
                    System.out.println("Erste Note muss zwischen 1 und 5 liegen!");
                    continue;
                }
                if (Character.getNumericValue(charArr[0]) < 1 || Character.getNumericValue(charArr[0]) > 5) {
                    System.out.println("Zweite Note muss zwischen 1 und 5 liegen!");
                    continue;
                }
                if (Character.getNumericValue(charArr[0]) < 1 || Character.getNumericValue(charArr[0]) > 5) {
                    System.out.println("Dritte Note muss zwischen 1 und 5 liegen!");
                    continue;
                }
                correctEntry = true;
            }
            catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Erneut Versuchen:");
                // collect the unconsumed wrong entry format
                sc.nextLine();
            }
        }
    }

}

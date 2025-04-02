package at.technikum.week5;

import java.util.Scanner;

// slightly different solution
// look at add again
// teils falsch

public class TimeCalculations {
    public static int hours = 0;
    public static int minutes = 0;

    public static int encode (int h, int m) {
        String codedHStr, codedMStr, codedHM;
        if (h == 0) {
            codedHStr = "00";
        } else if (h < 10) {
            codedHStr = "0" + String.valueOf(h);
        } else {
            codedHStr = String.valueOf(h);
        }

        if (m == 0) {
            codedMStr = "00";
        } else if (m < 10) {
            codedMStr = "0" + String.valueOf(m);
        } else {
            codedMStr = String.valueOf(m);
        }
        codedHM = "1" + codedHStr + codedMStr;
        // puts 1 at the beginning to preserve hhmm format with leading 0s in hh
        return Integer.parseInt(codedHM);
    };

    // changed int to void
    public static void read () {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Hour:");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input, try again:");
                sc.next();
            }
            hours = sc.nextInt();

            if (hours < 0 || hours > 23) {
                System.out.println("Invalid input, try again:");
            }
        } while (hours < 0 || hours >= 24);

        do {
            System.out.println("Minute:");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input, try again:");
                sc.next();
            }
            minutes = sc.nextInt();

            if (minutes < 0 || minutes > 59) {
                System.out.println("Invalid input, try again:");
            }
        } while (minutes < 0 || minutes > 59);

        sc.close();
    };

    public static int hours (int t) {
        String hStr = String.valueOf(t).substring(1,3);
        return Integer.parseInt(hStr);
    }

    public static int minutes (int t) {
        return t % 100;
    }

    public static void print (int t) {
        String hStr = String.valueOf(t).substring(1,3);
        String mStr = String.valueOf(t).substring(3,5);;
        System.out.println(hStr + ":" + mStr);
    }

    public static void add (int t1, int t2) {
        int minSum = minutes(t1) + minutes(t2);
        int hourSum = hours(t1) + hours(t2);

        if (minSum > 59) {
            hourSum++;
            minSum -= 60;
        }

        if (hourSum > 23) {
            hourSum -= 24;
        }

        encode(hourSum, minSum);
    }

    public static int total_minutes(int t) {
        return minutes(t) + (60 * hours(t));
    }
}

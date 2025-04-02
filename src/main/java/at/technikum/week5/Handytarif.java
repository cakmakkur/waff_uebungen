package at.technikum.week5;

import java.util.Scanner;

public class Handytarif {
    public static void run () {
        Scanner sc = new Scanner(System.in);

        double grund = 5.99;
        double zusatz = 0;
        double smsGrund = 0;
        double smsZusatz = 0;

        System.out.println("min:");
        int minutes = sc.nextInt();
        System.out.println("SMS:");
        int sms = sc.nextInt();

        if (minutes > 100) {
            for (int i = 100; i < minutes; i++) {
                zusatz += 0.99;
            }
        }

        if (sms < 10) {
            for (int i = 0; i < sms; i++) {
                smsZusatz += 0.05;
            }
        } else if (sms < 20) {
            smsGrund = 0.5;
            for (int i = 10; i < sms; i++) {
                smsZusatz += 0.04;
            }
        } else if (sms < 50) {
            smsGrund = 0.9;
            for (int i = 20; i < sms; i++) {
                smsZusatz += 0.03;
            }
        } else if (sms < 100) {
            smsGrund = 1.8;
            for (int i = 50; i < sms; i++) {
                smsZusatz += 0.02;
            }
        } else if (sms < 1000) {
            smsGrund = 2.8;
            for (int i = 100; i < sms; i++) {
                smsZusatz += 0.01;
            }
        } else {
            smsGrund = 11.8;
            for (int i = 1000; i < sms; i++) {
                smsZusatz += 0.005;
            }
        }

        System.out.printf("zu bezahlen: %.2f + %.2f + %.2f = %.2f", grund, zusatz, (smsZusatz + smsGrund), (grund + zusatz + smsZusatz + smsGrund));
    }
}

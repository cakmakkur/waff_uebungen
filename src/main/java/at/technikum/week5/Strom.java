package at.technikum.week5;

import java.util.ArrayList;
import java.util.Scanner;

public class Strom {
    public static void run () {
        Scanner sc = new Scanner(System.in);
        int MAX_ENTRIES = 16;
        int entries = 0;
        ArrayList<Float> arr = new ArrayList<>();
        System.out.println("Max. 16 Werte eingeben, 999 beendet:");
        while (entries < MAX_ENTRIES) {
            float newFloat = sc.nextFloat();
            if (newFloat == 999) break;
            if (newFloat > 100 || newFloat < -100) continue;
            arr.add(newFloat);
            entries++;
        }
        System.out.println("Eingelesen: " + entries);
        System.out.println("N: ");
        int n = sc.nextInt();
        if (n > arr.size()) {
            System.out.println("Zu wenige Werte");
            return;
        }

        float sum = 0;
        for (int i = arr.size() - n; i < arr.size(); i++) {
            sum += Math.abs(arr.get(i));
        }
        System.out.print("Wert = ");
        System.out.printf("%.2f", (sum / n));
    }
}

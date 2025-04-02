package at.technikum.week4;

import java.util.ArrayList;
import java.util.Scanner;

public class Notenstatistik {
    public Notenstatistik () {
        Scanner sc = new  Scanner(System.in);
        System.out.println("Enter Marks:");
        ArrayList<Double> arr = new ArrayList<>();
        int fuenfer = 0;
        double total = 0;
        while (sc.hasNext()) {
            double input = sc.nextDouble();
            if (input < 0 || input > 5) {
                System.out.println("Wrong input. Try again.");
                continue;
            }
            if (input == 0) {
                break;
            }
            if (input == 5) {
                fuenfer++;
            }
            total += input;
            arr.add(input);
        }

        double average = total / arr.size();
        System.out.printf("Average: %.2f ", average);
        System.out.print("Failed: " + fuenfer);
    }
}

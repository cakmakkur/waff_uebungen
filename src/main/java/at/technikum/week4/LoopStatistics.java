package at.technikum.week4;

import java.util.ArrayList;
import java.util.Scanner;

public class LoopStatistics {
    public LoopStatistics () {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> arr = new ArrayList<>();
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double total = 0;

        System.out.println("Enter numbers:");
        while (sc.hasNext()) {
            double input = sc.nextDouble();
            if (input <= 0) {
                break;
            }
            arr.add(input);
            total += input;
            if (input < min) {
                min = input;
            } else if (input > max) {
                max = input;
            }
        }

        if (arr.isEmpty()) {
            System.out.println("no number entered");
            return;
        }

        System.out.println("minimum: " + min);
        System.out.println("maximum: " + max);
        System.out.println("mean: " + (total / arr.size()));
    }
}

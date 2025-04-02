package at.technikum.week5;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class BMI {
    private static HashMap<Integer, String> hm = new HashMap<>();

    static {
        hm.put(11, "Severely underweight");
        hm.put(12, "Underweight");
        hm.put(20, "Normal");
        hm.put(30, "Overweight");
        hm.put(40, "Moderately obese");
        hm.put(41, "Severely obese");
        hm.put(42, "Very severely obese");
    }


    public static double bmiCalc(double height, double weight) {
        if (height < 1.6 || weight < 40) return -1;
        return weight / (Math.pow(height, 2));
    };

    public static int bmiCategory(double bmi) {
        if (bmi <= 0) return -1;

        if (bmi < 15) {
            return 10;
        } else if (bmi < 16) {
            return 11;
        } else if (bmi < 18.5) {
            return 12;
        } else if (bmi < 25) {
            return 20;
        } else if (bmi < 30) {
            return 30;
        } else if (bmi < 35) {
            return 40;
        } else if (bmi < 40) {
            return 41;
        } else {
            return 42;
        }
    };
    public static void bmiMessage (int bmiCategory) {
        String category = hm.get(bmiCategory);
        System.out.print(Objects.requireNonNullElse(category, "invalid"));
    };
}

        /* BMI-Aufgabe
        Scanner sc = new Scanner(System.in);
        double weight, height, bmi;
        System.out.println("weight [kg]: ");
        weight = sc.nextDouble();
        System.out.println("height [m]: ");
        height = sc.nextDouble();
        System.out.printf("m=%.2fkg h=%.2fm -> BMI=%.2f (", weight, height, bmi = BMI.bmiCalc(height, weight));
        BMI.bmiMessage(BMI.bmiCategory(bmi));
        System.out.print(")\n");
        */
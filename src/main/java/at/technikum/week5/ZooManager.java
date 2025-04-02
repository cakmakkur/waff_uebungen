package at.technikum.week5;

import java.util.Scanner;

public class ZooManager {
    private static final int INPUT_SIZE = 8;
    private static final double[] arr = new double[INPUT_SIZE];

    // removed parameter float values[] from all the original methods
    // using instead static array arr

    public static void read() {
        Scanner sc = new Scanner(System.in);
        int inputCount = 0;

        System.out.println("Enter values:");

        for (int i = 0; i < INPUT_SIZE; i++) {
            arr[inputCount] = sc.nextDouble();
            if (arr[inputCount] == 0) {
                break;
            }
            inputCount++;
        }
        sc.close();
    }

    public static void print(){
        System.out.print("{ ");
        for(double a : arr) {
            if (a == 0) break;
            System.out.printf("%.2f ", a);
        }
        System.out.print("}");
    }
    public static int count(){
        int count = 0;
        for (double a : arr) {
            if (a == 0) break;
            count++;
        }
        return count;
    }

    public static void clear(){
        for (int i = 0; i < INPUT_SIZE; i++) {
            arr[i] = 0;
        }
    }

    // changed float in method declaration to double
    public static double avg(){
        int count = 0;
        double sum = 0;
        for (double a : arr) {
            if (a == 0) break;
            count++;
            sum += a;
        }
        return sum / count;
    }

    public static float b_of_max_a(float[] a, float[] b){
        if (a.length == 0 && b.length == 0) return -1;

        float max = a[0];
        int ind = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                ind = i;
            }
        }
        return b[ind];
    }
}

// for main method:


/*
        ZooManager.read();
        System.out.println("The values are:");
        ZooManager.print();
        System.out.println();
        System.out.println("Number of elements: " + ZooManager.count());
        System.out.println("Average: " + ZooManager.avg());

float[] a = {0.1f, 0.2f, 0.99f, 0.4f};
float[] b = {0.3f, 0.4f, 0.5f, 0.6f};
        System.out.println("0.5 should be here: " + ZooManager.b_of_max_a(a,b));

        System.out.println("Array cleared: ");
        ZooManager.clear();
        ZooManager.print();*/

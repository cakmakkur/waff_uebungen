package at.technikum.week2;

import java.util.Scanner;

public class Cube {

    public void run () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of a side of the cube...");
        int a = sc.nextInt();
        double surface = Math.pow(a, 2) * 6;
        double volume = Math.pow(a, 3);
        System.out.println("Length of a side: " + a);
        System.out.println("Surface area: " + String.format("%.2f", surface));
        System.out.println("Volume: " + String.format("%.2f", volume));
        sc.close();
    }
}

package at.technikum.week2;

import java.util.Scanner;

public class Tax {
    Scanner sc = new Scanner(System.in);

    public void run () {
        System.out.println("Enter an amount");
        double i = sc.nextDouble();
        double taxed = i / 5 * 6;
        System.out.println("With tax added : " + String.format("%.2f", taxed));
    }
}

package at.technikum.week2;

import java.util.Scanner;

public class Geburtsdatum {
    Scanner sc = new Scanner(System.in);

    public void run () {
        System.out.println("Enter your birthday (TTMMJJ)");
        String bj = String.valueOf(sc.nextInt());
        System.out.println(bj.substring(4,6) + bj.substring(2,4) + bj.substring(0,2));
    }
}
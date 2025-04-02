package at.technikum.week4;

import java.util.Scanner;

public class Classifier {
    public void run () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter price:");
        int price = sc.nextInt();
        System.out.println("Enter quality");
        int quality = sc.nextInt();
        sc.close();

        if (price < 50 && quality < 50) {
            System.out.println("low price");
            System.out.println("low quality");
            System.out.println("junk");
        } else if (price >= 50 && quality < 50) {
            System.out.println("high price");
            System.out.println("low quality");
            System.out.println("rip off");
        } else if (price < 50) {
            System.out.println("low price");
            System.out.println("high quality");
            System.out.println("bargain");
        } else {
            System.out.println("high price");
            System.out.println("high quality");
            System.out.println("luxury");
        }

    }
}

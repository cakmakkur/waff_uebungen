package at.technikum.week2;

import java.util.Scanner;

public class DateFormatConverter {
    Scanner sc = new Scanner(System.in);

    public void run () {
        System.out.println("enter date (yyyymmdd)");
        int rawDate = sc.nextInt();
        if (rawDate < 15821016 || rawDate > 21001231) {
            System.out.println("invalid date");
            return;
        }
        String day = String.valueOf(rawDate).substring(6,8);
        String month = String.valueOf(rawDate).substring(4,6);
        String year = String.valueOf(rawDate).substring(0, 4);

        System.out.printf("%s.%s.%s", day, month, year);
    }
}

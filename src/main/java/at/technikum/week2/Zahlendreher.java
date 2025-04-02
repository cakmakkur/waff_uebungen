package at.technikum.week2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Zahlendreher {
    Scanner sc = new Scanner(System.in);

    public void run () {
        System.out.println("Enter a number (max 3 digits)");
        String numString = String.valueOf(sc.nextInt());

        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < numString.length(); i++) {
            deq.addLast(Character.getNumericValue(numString.charAt(i)));
        }
        while (!deq.isEmpty()) {
            System.out.print(deq.removeLast());
        }
            for (int i = 0; i < 3 - numString.length(); i++) {
                System.out.print(0);
            }
    }
}

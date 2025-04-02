package at.technikum.week5;

import java.util.Scanner;

public class PartyHandshake {
    public static String[] readNames(int n) {
        String[] arr = new String[n];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter names");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        sc.close();
        return arr;
    }

    public static String[] handShakes(String[] names) {
        if (names.length == 0) return new String[0];

        int factorial = 0;
        for (int i = names.length - 1; i > 0; i--) {
            factorial += i;
        }
        String[] hs = new String[factorial];

        int ind = 0;
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = i+1; j < names.length; j++) {
                String s = names[i] + " -> " + names[j];
                hs[ind] = s;
                ind++;
            }
        }
        return hs;
    }

    public static void print(String[] stra) {
        for (String s : stra) {
            System.out.println(s);
        }
    }
}

/*        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of people: ");
        int n = sc.nextInt();
        String[] names = PartyHandshake.readNames(n);
        String[] handshakes = PartyHandshake.handShakes(names);
        PartyHandshake.print(handshakes);
        sc.close();*/
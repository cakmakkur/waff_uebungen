package at.technikum.week4;

import java.util.Scanner;

public class GroesseGewicht {
    private int groesse;
    private int gewicht;

    private void print (String type) {
        boolean stern = groesse < 50 || gewicht > 200;
        System.out.println("Groesse: " + groesse);
        System.out.println("Gewicht: " + gewicht);
        System.out.println(type + (stern && !type.equals("Ungueltig!") ? " (*)" : ""));
    }
    public GroesseGewicht () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Height");
        groesse = sc.nextInt();
        System.out.println("Enter Weight");
        gewicht = sc.nextInt();
        sc.close();

        try {
            if (gewicht <= 0 || groesse <= 0) {
                throw new Exception();
            }
            if (gewicht <= 90 && groesse <= 200) {
                print("normal");
            } else if (gewicht > 90 && groesse <= 200) {
                print("uebergewichtig");
            } else if (gewicht <= 90) {
                print("hager");
            } else {
                print("riesig");
            }
        }
        catch (Exception e) {
            print("Ungueltig!");
        }
    }
}

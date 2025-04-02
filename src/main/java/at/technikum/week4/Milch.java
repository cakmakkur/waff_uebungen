package at.technikum.week4;

import java.util.Scanner;



public class Milch {

    public Milch () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Fettgehalt eingeben:");
        int f = sc.nextInt();
        System.out.println("Haltbarkeit eingeben (0: nicht haltbar, 1: haltbar):");
        int h = sc.nextInt();
        sc.close();

        System.out.println("Fettgehalt: " + f);
        System.out.println("Haltbarkeit: " + h);

        String haltbarkeit = h == 1 ? "(haltbar)" : "(frisch)";
        String art = f < 3 ? "Leichtmilch" : f > 7 ? "Extravollmilch" : "Normalmilch";

        if (h == 0 || h == 1) {
            System.out.println(art + " " + haltbarkeit);
        } else {
            System.out.println("Ungueltig!");
        }

    }
}

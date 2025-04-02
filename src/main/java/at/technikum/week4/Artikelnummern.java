package at.technikum.week4;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

record Artikel (int artikelGruppe, int untergruppe, int artikelNummer, String bezeichnung) {};

public class Artikelnummern {
    ArrayList<Artikel> arr = new ArrayList<>();

    private void populateArray () {
        arr.add(new Artikel(1,1,1, "Bier (hell, 0.5)"));
        arr.add(new Artikel(1,1,2, "Bier (hell, 0,33)"));
        arr.add(new Artikel(1,1,3, "Zwickel (0,5)"));
        arr.add(new Artikel(1,1,4, "Zwickel (0,33)"));
        arr.add(new Artikel(1,2,1,"Cola"));
        arr.add(new Artikel(1,2,2, "Fanta"));
        arr.add(new Artikel(1,3,1, "Rotwein"));
        arr.add(new Artikel(1,3,2,"Weißer Spritzer"));
        arr.add(new Artikel(2,1,1, "Schnitzel"));
        arr.add(new Artikel(2,1,2, "Schweinsbraten"));
        arr.add(new Artikel(2,2,1,"Frankfurter"));
        arr.add(new Artikel(2,9,1, "Ketchup"));
        arr.add(new Artikel(3,1,1,"Zigaretten"));
    }
    public Artikelnummern () {
        populateArray();
        int a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Artikelgruppe: ");
        a = sc.nextInt();
        System.out.println("Untergruppe: ");
        b = sc.nextInt();
        System.out.println("Artikelnummer: ");
        c= sc.nextInt();
        sc.close();
        Optional<Artikel> result = arr.stream().filter(artikel -> artikel.artikelGruppe() == a).filter(artikel -> artikel.untergruppe() == b).filter(artikel -> artikel.artikelNummer() == c).findFirst();
        if (result.isPresent()) {
            System.out.println(result.get().bezeichnung());
        } else {
            System.out.println("Falsche Eingabe");
        }
    }
}

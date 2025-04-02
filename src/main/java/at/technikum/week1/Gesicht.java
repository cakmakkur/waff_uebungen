package at.technikum.week1;

public class Gesicht {
    static {
        System.out.println("Gesicht");
        System.out.println("0123456789012345");
        System.out.println("________________");
        System.out.printf("\\%14s/%n", " ");
        System.out.printf("%s\\%2s\"\"\"%2s\"\"\"%2s/%n", " ", " ", " ", " ");
        System.out.printf("%2s\\%2so%4so%2s/%n", " ", " ", " ", " ");
        System.out.printf("%3s\\%3s--%3s/%n", " ", " ", " ");
        System.out.printf("%4s\\%6s/%n", " ", " ");
        System.out.printf("%5s\\====/%n", " ");
        System.out.printf("%6s\\==/%n", " ");
        System.out.printf("%7s\\/%n", " ");
    }
}
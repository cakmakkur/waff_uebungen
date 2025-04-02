package at.technikum.LearningStuff;

import java.util.Scanner;

public class BookShop {
    Scanner sc;

    public void run() {
        sc = new Scanner(System.in);
        System.out.println("Welcome to the Book Shop");
        System.out.println("1 - register new book");
        System.out.println("q - quit program");
        while (sc.hasNext()) {
            String input = sc.next();
            if (input.equals("1")) {
                registerBook();
            } else if (input.equals("q")) {
                break;
            }
            sc.nextLine();
        }
        sc.close();
        System.out.println("Goodbye");
    }

    private void registerBook() {
        BookFactory.BookTypes type;
        String name;
        int pageNumber;
        Book book = null;

        System.out.println("Type of the book:");
        int n = 1;
        for (BookFactory.BookTypes t : BookFactory.BookTypes.values()) {
            System.out.println(n++ + " - " + t);
        }
        int c = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter name of the book:");
        name = sc.nextLine();

        System.out.println("Enter number of pages:");
        pageNumber = sc.nextInt();
        sc.nextLine();

/*        BookFactory.BookTypes t;
        int ind = 0;
        for (BookFactory.BookTypes ty : BookFactory.BookTypes.values()) {
            ind = ty.ordinal();
        }*/

        if (c == 1) {
            book = BookFactory.publishBook(BookFactory.BookTypes.NOVEL, name, pageNumber);
        } else if (c == 2) {
            book = BookFactory.publishBook(BookFactory.BookTypes.BIOGRAPHY, name, pageNumber);
        } else {
            book = BookFactory.publishBook(null, name, pageNumber);
        }

        System.out.println("New book added:");
        System.out.println("Name: " + book.getName());
        System.out.println("Number of pages: " + book.getPageNumber());
        System.out.println("Description: " + book.describe());
        System.out.println();
        System.out.println("--book registered--");

    }
}

// for the main method:
//         BookShop shop = new BookShop();
//         shop.run();

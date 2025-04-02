package at.technikum.week5;

import java.util.Scanner;

public class ColorFunctions {
    private static final Scanner sc = new Scanner(System.in);

    public static void welcome() {
        System.out.println("Welcome to ColorFunctions!");
    }
    public static void good_bye() {
        System.out.println("Exiting ColorFunctions!");
    }

    // my method: (returns channel value with leading 0s in String format
    public static String format_channel (int i) {
        String str;
        if (i == 0) {
            str = "000";
        } else if (i < 10) {
            str = "00" + String.valueOf(i);
        } else if (i < 100) {
            str = "0" + String.valueOf(i);
        } else {
            str = String.valueOf(i);
        }
        return str;
    }

    public static int read_channel() {
        System.out.println("Enter value between 0-255:");
        int input;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input, try again:");
                sc.next();
            }
            input = sc.nextInt();
            if (input < 0 || input > 255) {
                System.out.println("Invalid input, try again:");
            }
        } while (input < 0 || input > 255);
        return input;
    }
    public static int encode(int c1, int c2, int c3) {
        String temp2, temp3;
        temp3 = format_channel(c3);
        temp2 = format_channel(c2);
        return Integer.parseInt(c1 + temp2 + temp3);
    }
    public static int read_rgb() {
        System.out.println("Red");
        int r = read_channel();
        System.out.println("Green");
        int g = read_channel();
        System.out.println("Blue");
        int b = read_channel();
        return encode(r,g,b);
    }
    public static int redOrCyan(int rgb) {
        return rgb / 1000000;
    }
    public static int greenOrMagenta(int rgb) {
        if (rgb < 1000) return 0;
        return (rgb / 1000) % 1000;
    }
    public static int blueOrYellow(int rgb) {
        if (rgb == 0) return 0;
        return rgb % 1000;
    }
    public static void print_rgb(int rgb) {
        String red = "R" + format_channel(redOrCyan(rgb));
        String green = "G" + format_channel(greenOrMagenta(rgb));
        String blue = "B" + format_channel(blueOrYellow(rgb));
        System.out.println(red + " " + green + " " + blue);
    }
    public static int rgb_2_cmy(int rgb) {
        int c = 255 - redOrCyan(rgb);
        int m = 255 - greenOrMagenta(rgb);
        int y = 255 - blueOrYellow(rgb);
        return encode(c,m,y);
    }

    // using red, green, blue methods for these:
    /*public static int cyan(int cmy) {}
    public static int magenta(int cmy) {}
    public static int yellow(int cmy) {}*/
    
    public static void print_cmy(int cmy) {
        String cyan = "C" + format_channel(redOrCyan(cmy));
        String magenta = "M" + format_channel(greenOrMagenta(cmy));
        String yellow = "Y" + format_channel(blueOrYellow(cmy));
        System.out.println(cyan + " " + magenta + " " + yellow);
    }
}

// main method
/*
        int rgbValue = ColorFunctions.read_rgb();
        ColorFunctions.print_rgb(rgbValue);
        System.out.println("CMY values: ");
        int cmyValue = ColorFunctions.rgb_2_cmy(rgbValue);
        ColorFunctions.print_cmy(cmyValue);
*/
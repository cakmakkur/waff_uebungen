package at.technikum.week5;

// not ready

import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

class Basics {
    private static final int MIN_DATE = 15821016;
    private static final int MAX_DATE = 21991231;

    static boolean checkDate(int y, int m, int d) {
        if (y < 0 || m < 0 || d < 0 || m > 12 || d > 31) return false;

        String monthStr = m < 10 ? "0" + m : Integer.toString(m);
        String dayStr = d < 10 ? "0" + d : Integer.toString(d);
        String dateStr = y + monthStr + dayStr;
        int date = Integer.parseInt(dateStr);

        return date >= MIN_DATE && date <= MAX_DATE;
    }

    static boolean checkDate(int y, int m) {
        if (y < 0 || m < 0 || m > 12) return false;

        String monthStr = m < 10 ? "0" + m : Integer.toString(m);
        String dateStr = y + monthStr + String.valueOf(MIN_DATE).substring(6, 8);
        int date = Integer.parseInt(dateStr);
        return date >= MIN_DATE && date <= MAX_DATE;
    }

    static boolean checkDate(int y) {
        return y >= Integer.parseInt(String.valueOf(MIN_DATE).substring(0, 4)) && y <= Integer.parseInt(String.valueOf(MAX_DATE).substring(0, 4));
    }

    public static boolean isLeap(int year) {
        return checkDate(year) && Year.isLeap(year);
    }

    public static int daysInMonth(int year, int month) {
        if (checkDate(year, month)) {
            LocalDate ld = LocalDate.of(year, month, 1);
            return ld.lengthOfMonth();
        }
        return -1;
    }
}

class Calculations {
    public static int ymd2w(int year, int month, int day) {
        if (!Basics.checkDate(year, month, day)) return -1;
        LocalDate ld = LocalDate.of(year, month, day);
        DayOfWeek d = ld.getDayOfWeek();
        return switch (d) {
            case SUNDAY -> 0;
            case MONDAY -> 1;
            case TUESDAY -> 2;
            case WEDNESDAY -> 3;
            case THURSDAY -> 4;
            case FRIDAY -> 5;
            case SATURDAY -> 6;
        };
    }

    public static int dayNumber(int year, int month, int day) {
        if (!Basics.checkDate(year, month, day)) return -1;
        LocalDate ld = LocalDate.of(year, month, day);
        return ld.getDayOfYear();
    }

    public static int weekNumber(int year, int month, int day) {
        if (!Basics.checkDate(year, month, day)) return -1;
        LocalDate ld = LocalDate.of(year, month, day);
        return ld.get(WeekFields.of(Locale.getDefault()).weekOfYear()) + 1;
    }
}

class Output {
    public static void printDayName(int day) {
        switch (day) {
            case 0 -> System.out.print("SUNDAY");
            case 1 -> System.out.print("MONDAY");
            case 2 -> System.out.print("TUESDAY");
            case 3 -> System.out.print("WEDNESDAY");
            case 4 -> System.out.print("THURSDAY");
            case 5 -> System.out.print("FRIDAY");
            case 6 -> System.out.print("SATURDAY");
            default -> System.out.print("invalid day");
        }
        ;
    }

    public static void printMonthName(int month) {
        switch (month) {
            case 1 -> System.out.print("JANUARY");
            case 2 -> System.out.print("FEBRUARY");
            case 3 -> System.out.print("MARCH");
            case 4 -> System.out.print("APRIL");
            case 5 -> System.out.print("MAY");
            case 6 -> System.out.print("JUNE");
            case 7 -> System.out.print("JULY");
            case 8 -> System.out.print("AUGUST");
            case 9 -> System.out.print("SEPTEMBER");
            case 10 -> System.out.print("OCTOBER");
            case 11 -> System.out.print("NOVEMBER");
            case 12 -> System.out.print("DECEMBER");
            default -> System.out.print("invalid month");
        }
        ;
    }

    public static void printNumberEnding(int n) {
        int rest = n % 10;

        if (rest == 1) {
            System.out.print("st");
        } else if (rest == 2) {
            System.out.print("nd");
        } else if (rest == 3) {
            System.out.print("nd");
        } else {
            System.out.print("th");
        }
    }

    public static void printDate(int year, int month, int day) {
        printDayName(Calculations.ymd2w(year, month, day));
        System.out.print(", ");
        printMonthName(month);
        System.out.print(" " + day);
        printNumberEnding(day);
        System.out.print(" " + year);
    }

    public static void printStatistics(int year, int month, int day) {
        System.out.println("statistics for:");
        printDate(year, month, day);
        System.out.println();
        if (Basics.isLeap(year)) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }
        printMonthName(month);
        System.out.print(" " + year + " has " + Basics.daysInMonth(year, month) + " days");
        System.out.println();
        System.out.print("it is the " + Calculations.dayNumber(year, month, day));
        System.out.println(" of " + year);
        System.out.println("it is in week " + Calculations.weekNumber(year, month, day));
    }
}

class Application {
    public static void printCalendar(int year, int month, int day) {
        // this part is from chatGPT
        YearMonth ym = YearMonth.of(year, month);
        int daysInMonth = Basics.daysInMonth(year, month);
        LocalDate firstDay = ym.atDay(1);
        DayOfWeek startDay = firstDay.getDayOfWeek();

        Output.printMonthName(month);
        System.out.println(" " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startOffset = startDay.getValue() % 7;  // Ensures Sunday = 0, Monday = 1, ..., Saturday = 6

        for (int i = 0; i < startOffset; i++) {
            System.out.print("    ");
        }

        // Print days
        for (int d = 1; d <= daysInMonth; d++) {
            if (d == day) {
                System.out.printf("<%2d> ", d); // Highlight the day
            } else {
                System.out.printf("%3d ", d);
            }

            // New line after Saturday
            if ((startOffset + d) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

public class Calendars {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date: (y-m-d)");
        while (sc.hasNext()) {
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();

            Output.printStatistics(y, m, d);
            Application.printCalendar(y, m, d);
        }
        sc.close();
    }
}

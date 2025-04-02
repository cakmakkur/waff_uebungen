package at.technikum.week1;

public class TheLifeOfPi {
    private final static double pi = 3.14159265359;
    private final static String str = "Pi ";
    static {
        System.out.printf("%s= %f!%n", str, pi);
        System.out.printf("%s= %12f!%n", str, pi);
        System.out.printf("%s= %12.2f!%n", str, pi);
        System.out.printf("%s= %10.0f!%n", str, pi);
        System.out.printf("%s= %13.11f!%n", str, pi);
        System.out.printf("%s= %015f!%n", str, pi);
        System.out.printf("%s= %+015.2f!%n", str, pi);
    }
}
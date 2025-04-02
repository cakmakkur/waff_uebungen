package at.technikum.week1;

public class NeighborOfTheBeast {
    private final static String str = "the neighbor of the beast: ";
    private final static int num = 667;
    static {
        System.out.println("Neighbor Of The Beast");
        System.out.printf("%s%d!%n", str, num);
        System.out.printf("%s%X!%n", str, num);
        System.out.printf("%s%9d!%n", str, num);
        System.out.printf("%s%d%7s%n", str, num, "!");
        System.out.printf("%s%08d!%n", str, num);
        System.out.printf("%s%+d%8s!%n", str, num, "");
    }
}
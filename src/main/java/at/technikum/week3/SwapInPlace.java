package at.technikum.week3;

public class SwapInPlace {
    private int a = 23;
    private int b = 5;

    public SwapInPlace () {
        System.out.println("Before a: " + a + " b: " + b);
        a += b;
        b = a - b;
        a = a - b;
        System.out.println("After a: " + a + " b: " + b);
    }

}

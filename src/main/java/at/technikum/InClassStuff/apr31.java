package at.technikum.InClassStuff;

public class apr31 {

    private static final int[] a = new int[5];


    public static void run() {
        populateArr();
        int sum1 = add(a);

        populateArr();
        int sum2 = add(a);

        System.out.println(sum1 + sum2);
    }

    private static void populateArr() {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 10);
        }
    }

    private static int add(int[] arg) {
        int sum = 0;
        for (int i : arg) {
            sum += i;
        }
        return sum;
    }


}

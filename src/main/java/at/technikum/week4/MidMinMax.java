package at.technikum.week4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MidMinMax {

    public MidMinMax() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie drei Zahlen ein:");
        Pair[] arr = new Pair[3];
        arr[0] = new Pair('a', sc.nextInt());
        arr[1] = new Pair('b', sc.nextInt());
        arr[2] = new Pair('c', sc.nextInt());

        sc.close();

        System.out.printf("a : %d%nb : %d%nc : %d%n", arr[0].value, arr[1].value, arr[2].value);

        Comparator<Pair> customComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.value, o2.value);
            }
        };

        Arrays.sort(arr, customComparator);
        System.out.print(arr[0].value + (arr[0].value == arr[1].value ? " = " : " < ") + arr[1].value);
        System.out.print((arr[1].value == arr[2].value) ? " = " : " < " + arr[2].value);
        System.out.println();
        System.out.print(arr[0].key + (arr[0].value == arr[1].value ? " = " : " < ") + arr[1].key);
        System.out.print((arr[1].value == arr[2].value) ? " = " : " < " + arr[2].key);


    }

    private static class Pair {
        char key;
        int value;

        public Pair(char a, int b) {
            key = a;
            value = b;
        }
    }

}

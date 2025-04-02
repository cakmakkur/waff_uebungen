package at.technikum.week4;

import java.util.Scanner;

public class Walter2 {
    private final static int UP = 8;
    private final static int DOWN = 2;
    private final static int RIGHT = 6;
    private final static int LEFT = 4;
    private final static int END = 5;


    int[] currentPos = {0, 9};
    int steps = 0;


    public Walter2 () {
        Scanner sc = new Scanner(System.in);
        drawField();
        System.out.println("Enter direction: (8: up, 6: right, 2: down, 4: left, 5: end");

        while (sc.hasNext()) {
            int input = sc.nextInt();
            switch (input) {
                case 8:
                    if (currentPos[1] > 0) {
                        currentPos[1]--;
                        steps++;
                    } else {
                        System.out.println("Action unmoeglich! - Try again");
                        continue;
                    }
                    drawField();
                    continue;
                case 2:
                    if (currentPos[1] < 9) {
                        currentPos[1]++;
                        steps++;
                    } else {
                        System.out.println("Action unmoeglich! - Try again");
                        continue;
                    }
                    drawField();
                    continue;
                case 6:
                    if (currentPos[0] < 9) {
                        currentPos[0]++;
                        steps++;
                    } else {
                        System.out.println("Action unmoeglich! - Try again");
                        continue;
                    }
                    drawField();
                    continue;
                case 4:
                    if (currentPos[0] > 0) {
                        currentPos[0]--;
                        steps++;
                    } else {
                        System.out.println("Action unmoeglich! - Try again");
                        continue;
                    }
                    drawField();
                    continue;
                default:
                    System.out.println("Unbekannte Aktion! - Try again");
            }
        }
    }

    private void movePosition (String direction) {

    }

    private void drawField () {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (x == currentPos[0] && y == currentPos[1]) {
                    System.out.print('X');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
}

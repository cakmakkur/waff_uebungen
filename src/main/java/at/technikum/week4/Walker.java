package at.technikum.week4;

import java.util.Scanner;

public class Walker {
    private final static int UP = 8;
    private final static int DOWN = 2;
    private final static int RIGHT = 6;
    private final static int LEFT = 4;
    private final static int END = 5;
    private final static int FIELD_SIZE = 10;
    int currentX = 0;
    int currentY = 9;
    int steps = 0;


    public Walker () {
        Scanner sc = new Scanner(System.in);
        drawField();

        System.out.println("Enter direction: (8: up, 6: right, 2: down, 4: left, 5: end");

        while (sc.hasNext()) {
            int input = sc.nextInt();

            if (input == END) {
                System.out.println("Programm endet");
                System.out.println("Schritte: " + steps);
                break;
            }

            if(changePosition(input)) {
                drawField();
            }
        }
        sc.close();
    }

    private boolean changePosition (int direction) {
        int newX = currentX;
        int newY = currentY;

        switch (direction) {
            case UP:
                newY--;
                break;
            case DOWN:
                newY++;
                break;
            case LEFT:
                newX--;
                break;
            case RIGHT:
                newX++;
                break;
            default:
                System.out.println("Unbekannte Aktion...");
                return false;
        }

        if (newX < 0 || newX == FIELD_SIZE || newY < 0 || newY == FIELD_SIZE) {
            System.out.println("Action unmoeglich! - Try again");
            return false;
        }

        steps++;
        currentX = newX;
        currentY = newY;
        return true;
    }

    private void drawField () {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (x == currentX && y == currentY) {
                    System.out.print('X');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
}

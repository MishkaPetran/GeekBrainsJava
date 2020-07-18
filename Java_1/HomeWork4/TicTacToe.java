import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class TicTacToe {
    public static char[][] filed;
    public static final int filedSize = 3;
    public static final int dotsToWin = 3;

    public static final char DOT_EMPTY = '_';
    public static final char DOT_X = 'X';
    public static final char DOT_Y = 'O';

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        initMap();
        printFiled();
        while (true){
            humanTurn();
            printFiled();

            if (checkWin(DOT_X)) {
                System.out.println("Вы победили!");
                break;
            }

            pcTurn();
            printFiled();
            if (checkWin(DOT_Y)) {
                System.out.println("Компьютер победил!");
                break;
            }

            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Игра закончена");

    }

    public static void initMap() {
        filed = new char[filedSize][filedSize];
        for (int i = 0; i < filedSize; i++) {
            for (int j = 0; j < filedSize; j++) {
                filed[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printFiled() {
        for (int i = 0; i < filedSize; i++) {
            for (int j = 0; j < filedSize; j++) {
                System.out.print(filed[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        filed[x][y] = DOT_X;
    }

    public static void pcTurn() throws InterruptedException {
        int x, y;
        do {
            System.out.print("Ходит компьютер");
            sleep(500);
            System.out.print(".");
            sleep(500);
            System.out.print(".");
            sleep(500);
            System.out.println(".");
            x = random.nextInt(filedSize);
            y = random.nextInt(filedSize);
        } while (!isCellValid(x, y));

        filed[x][y] = DOT_Y;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x > filedSize || y < 0 || y > filedSize){
            return false;
        } else if (filed[x][y] == DOT_EMPTY) return true;

        return false;
    }

    public static boolean checkWin(char symb) {
        return checkX(symb) || checkY(symb) || checkDiagonals(symb);
    }

    public static boolean checkX(char symb){
        for (int i = 0; i < filedSize; i++) {
            int winCount = 1;
            for (int j = 1; j < filedSize; j++) {
                if (symb == filed[i][j]){
                    winCount += 1;
                }

                if (winCount == dotsToWin){
                    System.out.println("checkX");
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkY(char symb){
        for (int i = 0; i < filedSize; i++) {
            int winCount = 1;
            for (int j = 1; j < filedSize; j++) {
                if (symb == filed[j][i]){
                    winCount += 1;
                }

                if (winCount == dotsToWin){
                    System.out.println("checkY");
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDiagonals(char symb){
        int winCount = 1;
        for (int i = 1; i < filedSize; i++) {
            if (symb == filed[i][i]){
                winCount += 1;
                if (winCount == dotsToWin) {
                    System.out.println("checkDX");
                    return true;
                }
            }
        }

        for (int i = 1; i < filedSize; i++) {
            if (symb == filed[filedSize - i - 1][i]){
                winCount += 1;
                if (winCount == dotsToWin) {
                    System.out.println("checkDY");
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isFieldFull(){
        for (int i = 0; i < filedSize; i++) {
            for (int j = 0; j < filedSize; j++) {
                if (filed[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}

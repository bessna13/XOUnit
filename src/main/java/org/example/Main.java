package org.example;

import java.util.Scanner;

public class Main {
    public static final int SIZE = 3;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = 'O';

    public static void main(String[] args) {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }

        Scanner scanner = new Scanner(System.in);

        boolean isCrossTurn = true;

        while (true) {
            printField(field);
            System.out.println("Ходят " + (isCrossTurn ? "крестики" : "нолики") + "!");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            int r = Integer.parseInt(parts[0]) - 1;
            int c = Integer.parseInt(parts[1]) - 1;

            if (field[r][c] != EMPTY) {
                System.out.println("Сюда ходить нельзя");
                continue;
            }

            field[r][c] = isCrossTurn ? CROSS : ZERO;
            if (isWin(field, isCrossTurn ? CROSS : ZERO)) {
                printField(field);
                System.out.println("Победили " + (isCrossTurn ? "крестики" : "нолики"));
                break;
            } else {
                if (isCrossTurn) {
                    isCrossTurn = false;
                } else {
                    isCrossTurn = true;
                }
            }
        }

        System.out.println("Игра закончена!");
    }

    public static boolean isWin(char[][] field, char player) {
        int playerCountDiag1 = 0;
        int playerCountDiag2 = 0;
        for (int row = 0; row < SIZE; row++) {
            int playerCountRow = 0;
            int playerCountCol = 0;
            for (int col = 0; col < SIZE; col++) {
                if (field[row][col] == player) {
                    playerCountRow++;
                }
                if (field[col][row] == player){
                    playerCountCol++;
                }

            }
            if (field[row][row] == player){
                playerCountDiag1++;
            }
            if (field[row][SIZE-(row + 1)] == player){
                playerCountDiag2++;
            }
            if (playerCountRow == SIZE || playerCountCol == SIZE || playerCountDiag1 == SIZE || playerCountDiag2 == SIZE)  {
                return true;
            }

        }
        return false;
    }
    public static void printField ( char[][] field){
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

}


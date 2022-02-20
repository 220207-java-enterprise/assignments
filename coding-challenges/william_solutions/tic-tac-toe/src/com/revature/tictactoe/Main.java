package com.revature.tictactoe;

public class Main {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X'},
                          {'O', 'O', 'X'},
                          {'O', 'X', 'O'}};

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                System.out.println("Row: " + i + " Col: " + j + " Value: " + board[i][j]);
            }
        }
        /*char winner = 'n';
        int turns = 0;

        do {
            //print board

        }while (winner == 'n');

        System.out.println("The winner is: " + winner);*/
    }
}

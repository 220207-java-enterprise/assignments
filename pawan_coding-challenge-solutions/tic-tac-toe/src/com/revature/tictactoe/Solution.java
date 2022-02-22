package com.revature.tictactoe;

public class Solution {
    public char validateWin(char[][] board) {

        char [][] boardGame = new char[3] [3];
        for (int i = 0; i < boardGame.length; i++){
            for(int j = 0; j < boardGame.length; j++){
                System.out.println(boardGame[j]);
            }
            System.out.println(boardGame[i]);
        }
        return ' ';
    }
}

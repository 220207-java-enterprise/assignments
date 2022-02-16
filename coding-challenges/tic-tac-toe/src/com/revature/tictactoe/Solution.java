package com.revature.tictactoe;

public class Solution {
    public char validateWin(char[][] board) {
        return ' ';
    }
      for(int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2]) {
                if (board[i][j] == 'X') {
                    return 'X';
                } else {
                    return 'O';
                }
            } else if (board[i][j] == board[i + 1][j]&&board[i + 1][j] == board[i + 2][j]) {
                if (board[i][j] == 'X') {
                    return 'X';
                } else {
                    return 'O';
                }
            } else if (board[i][j] == board[i + 1][j + 1]&&board[i + 1][j + 1] == board[i + 2][j + 2]) {
                if (board[i][j] == 'X') {
                    return 'X';
                } else {
                    return 'O';
                }
            } else if (board[i + 2][j] == board[i + 1][j + 1]&&board[i + 1][j + 1] == board[i][j + 2]) {
                if (board[i][j] == 'X') {
                    return 'X';
                } else {
                    return 'O';
                }
            } else {
                return 'N';
            }
        }
    }

}


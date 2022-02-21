package com.revature.tictactoe;

public class Solution {
    public char validateWin(char[][] board) {
        if (xHorizontal(board) == true) {
            return 'X';
        } else if (xVertical(board) == true) {
            return 'X';
        }

        return 'T';
    }

    private Boolean xHorizontal(char[][] board) {
        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') {
            return true;
        } else if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') {
            return true;
        } else if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') {
            return true;
        }

        return false;
    }

    private Boolean xVertical(char[][] board) {
        if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') {
            return true;
        } else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
            return true;
        } else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
            return true;
        }

        return false;
    }
}

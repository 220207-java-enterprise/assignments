package com.revature.tictactoe;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Solution {
    public char validateWin(char[][] board) {
        if (xHorizontal(board) == true) {
            return 'X';
        } else if (xVertical(board) == true) {
            return 'X';
        }else if(xDiagonal(board) == true) {
            return 'X';
        }else if (oHorizontal(board) == true){
            return 'O';
        } else if (oVertical(board) == true){
            return 'O';
        } else if(oDiagonal(board) == true){
            return 'O';
        }
        else {
            return 'T';
        }
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

    private Boolean oHorizontal(char[][] board) {
        if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') {
            return true;
        } else if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') {
            return true;
        } else if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') {
            return true;
        }

        return false;
    }

    private Boolean oVertical(char[][] board) {
        if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') {
            return true;
        } else if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
            return true;
        } else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
            return true;
        }

        return false;
    }

    private Boolean oDiagonal(char[][] board){
        if (board[0][0] == 'O' && board[1][1] == 'O' && board[0][0] == board[2][2]){
            return true;
        } else if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][0] == board[0][2]){
            return true;
        }
        return false;
    }

    private Boolean xDiagonal(char[][] board){
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[0][0] == board[2][2]){
            return true;
        } else if (board[2][0] == 'X' && board[1][1] == 'X' && board[0][0] == board[0][2]){
            return true;
        }
        return false;
    }
}
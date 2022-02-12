package com.revature.tictactoe;

public class Solution {
    public char validateWin(char[][] board) {
        if (board[0][0] == board[0][1] && board[0][1]== board[0][2])
            return  board[0][0];
        else if (board[1][0] == board[1][1] && board[1][1]== board[1][2])
            return  board[1][0];
        else if (board[2][0] == board[2][1] && board[2][1]== board[2][2])
            return  board[2][0];
        else if (board[0][0] == board[1][0] && board[1][0]== board[2][0])
            return  board[0][0];
        else if (board[0][1] == board[1][1] && board[1][1]== board[2][1])
            return  board[0][1];
        else if (board[0][2] == board[1][2] && board[1][2]== board[2][2])
            return  board[0][2];
        else if (board[0][0] == board[1][1] && board[1][1]== board[2][2])
            return  board[0][0];
        else if (board[0][2] == board[1][1] && board[1][1]== board[2][0])
            return  board[0][2];
        else
            return ' ';
    }
}


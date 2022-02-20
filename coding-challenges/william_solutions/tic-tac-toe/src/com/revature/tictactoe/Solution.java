package com.revature.tictactoe;

public class Solution {
    public char checkRows(char[] boardRow) {
        char haveAWinner = 'T';
        for(int i=0; i<boardRow.length-1; i++){
            if(boardRow[i] == boardRow[i+1])
                haveAWinner = boardRow[i];
            else {
                haveAWinner = 'T';
                return haveAWinner;
            }
        }
        return haveAWinner;
    }

    public char checkCols(char[][] board) {
        char haveAWinner = 'T';
        for(int i=0; i<board.length; i++){
                if(board[0][i] == board[1][i] && board[0][i]== board[2][i])
                    haveAWinner = board[1][i];
        }
        return haveAWinner;
    }

    public char checkDiagonals(char[][] board) {
        char win = 'T';
        //check left to right first
        if (board[0][0] == board[1][1] && board[0][0] == board [2][2])
            win = board[0][0];
        else if (board[2][0] == board[1][1] && board[1][1] == board[0][2])
            win = board[1][1];
        return win;
    }

    public char validateWin(char[][] board) {
        char win = 'n';

        //check rows for a win
        for(int i = 0; i<board.length;i++) {
            win = checkRows(board[i]);
            if (win == 'O' || win == 'X')
                return win;
        }

        //check columns for winner
        win = checkCols(board);
        if(win == 'O' || win == 'X')
            return win;

        //check diagonals for winner
        win = checkDiagonals(board);

        return win;
    }
}

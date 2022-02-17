package com.revature.tictactoe;

public class Solution {
    public char checkRows(char[] boardRow) {
        char haveAWinner = 'n';
        for(int i=0; i<boardRow.length-1; i++){
            if(boardRow[i] == boardRow[i+1])
                haveAWinner = boardRow[i];
            else {
                haveAWinner = 'n';
                return haveAWinner;
            }
        }
        return haveAWinner;
    }

    public char checkCols(char[][] board) {
        char haveAWinner = 'n';
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {

            }
        }
        return haveAWinner;
    }

    public char checkDiagonals(char[][] board) {
        return 'a';
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

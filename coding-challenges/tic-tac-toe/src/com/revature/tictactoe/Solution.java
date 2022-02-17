package com.revature.tictactoe;

public class Solution {
    public char validateWin(char[][] board) {
        if (xHorizontal(board))



        return ' ';
    }

    private Boolean xHorizontal(char[][] board){
        if (board [0][0] =='X' && board[0][1] == 'x' && board[O][2] == 'X'){
            return true;
        }
    }
}

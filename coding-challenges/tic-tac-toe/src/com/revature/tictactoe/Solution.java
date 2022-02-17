package com.revature.tictactoe;

public class Solution {
    public char validateWin(char[][] board) {

        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if (board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2]) {
                    System.out.println(board[i][j] + " WINS!");
                    return board[i][j];
                }
                if (board[i][j] == board[i+2][j+1] && board[i][j+1] == board[i][j+2]) {
                    System.out.println(board[i][j] + " WINS!");
                    return board[i][j];
                }
                if (board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2]) {
                    System.out.println(board[i][j] + " WINS!");
                    return board[i][j];
                }
            }
        }

        if (board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            System.out.println(board[0][0] + " WINS!");
            return board[0][0];
        } else if (board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            System.out.println(board[0][0] + " WINS!");
            return board[0][0];
        } else if (board[0][0]==board[1][1] && board[1][1]==board[2][2]){
            System.out.println(board[0][0] + " WINS!");
        }

        System.out.println("It's a tie!");
        return 'T';

    }
}

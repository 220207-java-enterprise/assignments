package com.revature.tictactoe;

import java.util.Arrays;
import java.util.Objects;

public class Solution {
    char X = 'X';
    char O = 'O';
    char T = 'T';

    public char validateWin(char[][] board) {
        //checks rows for winner
        for (int i = 0; i < board.length; i++){
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                System.out.println(board[i][0]+" Wins!");
                if (board[i][0] == X){
                    return X;
                }
                if (board[i][0] == O) {
                    return O;
                }
            }
        }
        //checks columns for winner
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                System.out.println(board[0][i]+" Wins!");
                if (board[0][i] == X){
                    return X;
                }
                if (board[0][i] == O){
                    return O;
                }
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            System.out.println(board[0][0]+" Wins!");
            if (board[0][0] == X){
                return X;
            }
            if (board[0][0] == O){
                return O;
            }
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            System.out.println(board[0][2]+" Wins!");
            if (board[0][2] == X){
                return X;
            }
            if (board[0][2] == O){
                return O;
            }
        }
        else {
            System.out.println("No one wins!");
            return T;
        }
    return T;
    }
}

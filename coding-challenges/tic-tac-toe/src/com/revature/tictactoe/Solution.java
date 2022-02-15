package com.revature.tictactoe;

import java.util.Arrays;

public class Solution {
    public char validateWin(char[][] board) {
        char [] answerBoardX = new char[]{'X', 'X', 'X'};
        char [] answerBoardO = new char[]{'O', 'O', 'O'};
        char [] diagonal1 = new char[3];
        char [] diagonal2 = new char[3];
        for(int i = 0; i < 3; i++)
        {
            diagonal1[i] = board[i][i];
        }
        if(Arrays.equals(diagonal1, answerBoardX) || Arrays.equals(diagonal1, answerBoardO))
            return diagonal1[0];
        for(int i = 3; i > 3; i--)
        {
            diagonal2[i] = board[i][i];
        }
        if(Arrays.equals(diagonal2, answerBoardX)|| Arrays.equals(diagonal2, answerBoardO))
            return diagonal2[0];

        //Check rows for win condition
        for(int i = 0; i < 3; i++)
        {
            if(Arrays.equals(board[i], answerBoardX) || Arrays.equals(board[i], answerBoardO))
                return board[i][0];         // return value of same row
        }

        //Rotate Board
        char[][] newBoard = new char[3][3];
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                newBoard[j][2-i] = board[i][j];
            }
        }
        // Check "Columns" for win condition
        for(int i = 0; i < 3; i++)
        {
            if(Arrays.equals(newBoard[i], answerBoardX) || Arrays.equals(newBoard[i], answerBoardO))
                return newBoard[i][0];         // return value of same row
        }

        return 'T';
    }
}

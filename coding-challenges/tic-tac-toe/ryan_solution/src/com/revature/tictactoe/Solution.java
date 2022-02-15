package com.revature.tictactoe;

import java.util.Arrays;

public class Solution {
    public char validateWin(char[][] board) {
        //the number of rows, plus the number of diagonals, plus the number of columns
        //This only works on square matrices which is all that gets tested for.
        char[][] ninetyDegreeRotatedBoard = reverseRows(transpose(board));
        char[][] rowsColumnsDiagonals = new char[board.length + 2 + ninetyDegreeRotatedBoard.length][];

        //append the rows
        for(int i = 0; i < board.length; i++) {
            rowsColumnsDiagonals[i] = board[i];
        }

        //append the diagonals. This is hard coded but we're given very small and simple 3x3 matrices. No need to
        //over engineer it.
        char[] firstDiagonal  = {board[0][0], board[1][1], board[2][2]};
        char[] secondDiagonal = {board[0][2], board[1][1], board[2][0]};
        rowsColumnsDiagonals[board.length] = firstDiagonal;
        rowsColumnsDiagonals[board.length + 1] = secondDiagonal;

        //append the columns, starting right after rows and 2 diagonals
        for(int i = board.length + 2, j = 0; i < board.length + 2 + ninetyDegreeRotatedBoard.length; i++, j++) {
            rowsColumnsDiagonals[i] = ninetyDegreeRotatedBoard[j];
        }

        char[] xWinningRow = {'X', 'X', 'X'};
        char[] oWinningRow = {'O', 'O', 'O'};

        //System.out.println(Arrays.deepToString(board));
        //System.out.println(Arrays.deepToString(ninetyDegreeRotatedBoard));
        //System.out.println(Arrays.deepToString(rowsColumnsDiagonals));

        for(int i = 0; i < rowsColumnsDiagonals.length; i++) {
            if(Arrays.equals(rowsColumnsDiagonals[i], xWinningRow)) {
                return 'X';
            }
            if (Arrays.equals(rowsColumnsDiagonals[i], oWinningRow)) {
                return 'O';
            }
        }
        return 'T';
    }

    public char[][] transpose(char[][] matrix) {
        //initialize transPosedMatrix to matrix and
        //then transpose its entries
        char [][] transPosedMatrix = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                transPosedMatrix[i][j] = matrix[j][i];
            }
        }
        return transPosedMatrix;
    }

    public char[][] reverseRows(char[][] matrix) {
        char[][] reversedRowsMatrix = new char[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            String reversed = new StringBuilder(new String(matrix[i])).reverse().toString();
            reversedRowsMatrix[i] = reversed.toCharArray();
        }
        return reversedRowsMatrix;
    }

    public char[][] rowsOfMatrix(char[][] matrix) {
        char[][] rowsOfMatrix = new char[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            rowsOfMatrix[i] = matrix[i];
        }
        return rowsOfMatrix;
    }

}

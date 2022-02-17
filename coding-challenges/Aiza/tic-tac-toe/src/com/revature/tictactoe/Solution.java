package com.revature.tictactoe;

public class Solution {
    public char validateWin(char[][] board) {

      for(int i = 0; i < 3; i++) {

          if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {//horizantal
              if (board[i][0] == 'X') {
                  return 'X';
              } else {
                  return 'O';
              }
          } else if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {//vertical
              if (board[0][i] == 'X') {
                  return 'X';
              } else {
                  return 'O';
              }
          } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {//diagnol lr
              if (board[0][i] == 'X') {
                  return 'X';
              } else {
                  return 'O';
              }
          } else if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
              if (board[2][0] == 'X') {
                  return 'X';
              } else {
                  return 'O';
              }
          }
      }
        return 'T';
    }

}


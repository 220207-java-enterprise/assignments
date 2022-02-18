package com.revature.tictactoe;

public class Main {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X'},
                          {'O','O','X'},
                          {'X', 'O','O'}};

        new Solution().validateWin(board);
    }
}

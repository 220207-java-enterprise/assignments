package com.revature.tictactoe;

public class Main {
    public static void main(String[] args) {
        char[][] board =
            {
                {'X', 'X', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'O'}
            };

        new Solution().validateWin(board);
    }
}

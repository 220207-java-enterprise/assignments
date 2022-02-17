package com.revature.tictactoe;

public class Main {
    public static void main(String[] args) {
        char[][] board = {  {'X', 'O', 'X'},
                            {'O', 'O', 'X'},
                            {'X', 'X', 'X'}};
        char solution = new Solution().validateWin(board);
    }
}

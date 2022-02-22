package com.revature.tictactoe;

public class Main {
    public static void main(String[] args) {
        char[][] board = {  {'X', 'O', 'O'},
                            {'O', 'X', 'O'},
                            {'X', 'X', 'O'}};
        System.out.println(new Solution().validateWin(board));
    }
}

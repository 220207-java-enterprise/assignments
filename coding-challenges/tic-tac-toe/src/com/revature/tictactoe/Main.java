package com.revature.tictactoe;

public class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        char[][] board =    {{'X','O','X'},
                            {'O','O','X'},
                            {'X','O','O'},};

        System.out.println(sl.validateWin(board));
    }
}

package com.revature.tictactoe;

public class Solution {
    public char validateWin(char[][] board) {
        if(board[0][0] == 'X'){
            if (board[0][1] == 'X'){
                if (board[0][2] == 'X'){
                    //System.out.println("");
                    return 'X';
                }
            }
            if (board[1][0] == 'X'){
                if (board[2][0] == 'X'){
                    //System.out.println("");
                    return 'X';
                }
            }
            if (board[1][1] == 'X'){
                if (board[2][2] == 'X'){
                    //System.out.println("");
                    return 'X';
                }
            }
        }

        else if(board[0][0] == 'O'){
            if (board[0][1] == 'O'){
                if (board[0][2] == 'O'){
                    //System.out.println("");
                    return 'O';
                }
            }
            if (board[1][0] == 'O'){
                if (board[2][0] == 'O'){
                    //System.out.println("");
                    return 'O';
                }
            }
            if (board[1][1] == 'O'){
                if (board[2][2] == 'O'){
                    //System.out.println("");
                    return 'O';
                }
            }
        }

        if(board[1][1] == 'X'){
            if (board[1][0] == 'X'){
                if (board[1][2] == 'X'){
                    //System.out.println("");
                    return 'X';
                }
            }
            if (board[0][1] == 'X'){
                if (board[2][1] == 'X'){
                    //System.out.println("");
                    return 'X';
                }
            }
            if (board[0][2] == 'X'){
                if (board[2][0] == 'X'){
                    //System.out.println("");
                    return 'X';
                }
            }
        }

        else if(board[1][1] == 'O'){
            if (board[1][1] == 'O'){
                if (board[1][2] == 'O'){
                    //System.out.println("");
                    return 'O';
                }
            }
            if (board[0][1] == 'O'){
                if (board[2][1] == 'O'){
                    //System.out.println("");
                    return 'O';
                }
            }
            if (board[0][2] == 'O'){
                if (board[2][0] == 'O'){
                    //System.out.println("");
                    return 'O';
                }
            }
        }

        if(board[2][2] == 'X'){
            if (board[1][2] == 'X'){
                if (board[0][2] == 'X'){
                    //System.out.println("");
                    return 'X';
                }
            }
            if (board[2][1] == 'X'){
                if (board[2][0] == 'X'){
                    //System.out.println("");
                    return 'X';
                }
            }
        }

        else if(board[2][2] == 'O'){
            if (board[1][2] == 'O'){
                if (board[0][2] == 'O'){
                    //System.out.println("");
                    return 'O';
                }
            }
            if (board[2][1] == 'O'){
                if (board[2][0] == 'O'){
                    //System.out.println("");
                    return 'O';
                }
            }
        }
        return 'T';
    }
}

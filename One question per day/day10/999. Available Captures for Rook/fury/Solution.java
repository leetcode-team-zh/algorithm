package com.dpc.algorithm;


import java.util.Stack;

class Solution {

    public int numRookCaptures(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'R') {
                    return canCapture(board, row, col, i, j);
                }
            }
        }
        return 0;
    }

    private int canCapture(char[][] board, int row, int col, int i, int j) {
        int num = 0;
        int up = i - 1;
        while (up >= 0) {
            char c = board[up][j];
            if (c == '.') {
                up--;
            } else {
                if (c == 'p') {
                    num++;
                }
                break;
            }
        }
        int right = j + 1;
        while (right < col) {
            char c = board[i][right];
            if (c == '.') {
                right++;
            } else {
                if (c == 'p') {
                    num++;
                }
                break;
            }
        }

        int left = j - 1;
        while (left >= 0) {
            char c = board[i][left];
            if (c == '.') {
                left--;
            } else {
                if (c == 'p') {
                    num++;
                }
                break;
            }
        }

        int down = i + 1;
        while (down < row) {
            char c = board[down][j];
            if (c == '.') {
                down++;
            } else {
                if (c == 'p') {
                    num++;
                }
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        char[][] board = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        Solution solution = new Solution();
        System.out.println(solution.numRookCaptures(board));
    }


}





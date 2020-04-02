package com.dpc.algorithm.leetcode;


public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int numOfOne = 0;
                int numOfZero = 0;
                for (int[] dir : directions) {
                    int curX = i + dir[0];
                    int curY = j + dir[1];
                    if (inArea(curX, curY, row, col)) {
                        int value = board[curX][curY];
                        if (value == 1 || value == 10) numOfOne++;
                        else numOfZero++;
                    }
                }

                if (board[i][j] == 0 && numOfOne == 3) board[i][j] = 101; // 0->1
                if (board[i][j] == 1 && (numOfOne < 2 || numOfOne > 3)) board[i][j] = 10; // 1->0
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int value = board[i][j];
                if (value == 101) board[i][j] = 1;
                if (value == 10) board[i][j] = 0;
            }

        }
    }

    private boolean inArea(int x, int y, int row, int col) {
        if (x < 0 || x >= row) return false;
        if (y < 0 || y >= col) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        Solution solution = new Solution();
        solution.gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }

    }
}


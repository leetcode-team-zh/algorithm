package leetcode.d289;

import java.util.Arrays;

public class Solution {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] copy = new int[m][n];
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                //八个方向的活细胞个数
                int liveCounts = getLiveCounts(copy,i,j);
                if(copy[i][j] == 0 && liveCounts == 3){
                    board[i][j] = 1;
                }

                if(copy[i][j] == 1 && (liveCounts > 3 || liveCounts < 2)){
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int getLiveCounts(int[][] board,int i,int j){
        int[][] directors = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
        int liveCounts = 0;
        int m = board.length;
        int n = board[0].length;
        for(int[] d : directors){
            int r = i + d[0];
            int c = j + d[1];
            if(r >= 0 && r < m && c >=0 && c < n){
                liveCounts += board[r][c];
            }
        }
        return liveCounts;
    }

}

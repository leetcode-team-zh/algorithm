package leetcode.d542;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] directors = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Point> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] result = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()){
            Point point = queue.poll();
            for(int i = 0 ; i < 4; i++){
                int r = point.x + directors[i][0];
                int c = point.y + directors[i][1];
                if(r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]){
                    result[r][c] = result[point.x][point.y] + 1;
                    queue.offer(new Point(r,c));
                    visited[r][c] = true;
                }
            }
        }
        return result;
    }

    public static class Point{
        int x;
        int y;

        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}

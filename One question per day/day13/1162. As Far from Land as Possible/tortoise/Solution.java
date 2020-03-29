package leetcode.d1162;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxDistance(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }

        //使用BFS
        // 方向向量
        int M = grid.length;
        int N = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0 ; i < M ; i++){
            for(int j = 0; j < N ; j++){
                if(grid[i][j] == 1){
                    queue.offer(new Point(i,j,grid[i][j]));
                }
            }
        }

        if(queue.isEmpty() || queue.size() == M * N){
            return -1;
        }

        int depth = -1;
        while(!queue.isEmpty()){
            depth ++;

            //把一层取完
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                Point point = queue.poll();
                //侵占周围(上，下，左，右)的海洋
                for(int j = 0 ; j < 4; j++){
                    int x = point.x + directions[j][0];
                    int y = point.y + directions[j][1];
                    if(x < 0 || x >= M || y < 0 || y >= N || grid[x][y] != 0){
                        continue;
                    }
                    grid[x][y] = -1;
                    queue.offer(new Point(x,y,grid[x][y]));
                }
            }
        }
        return depth;
    }

    private class Point{
        int x;
        int y;
        int data;
        public Point(int x,int y,int data){
            this.x = x;
            this.y = y;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        new Solution().maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}});
    }
}

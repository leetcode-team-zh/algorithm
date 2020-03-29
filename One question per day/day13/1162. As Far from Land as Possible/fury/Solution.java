package com.dpc.algorithm;


import java.util.LinkedList;
import java.util.Queue;

class Solution {

    /*
    Input: [[1,0,1],[0,0,0],[1,0,1]]
    Output: 2
    Explanation:
    The cell (1, 1) is as far as possible from all the land with distance 2.
    */

    static class Point {
        int x;
        int y;
        int dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int maxDistance = -1;
        Queue<Point> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Point(i, j, 0));
                }
            }
        }

        // 如果没有陆地或者全是陆地，直接返回-1
        if (queue.size() == 0 || queue.size() == n * n) return maxDistance;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x < 0 || p.x > grid.length - 1 || p.y < 0 || p.y > grid[0].length - 1)
                continue;
            if (!visited[p.x][p.y]) {
                visited[p.x][p.y] = true;
                maxDistance = Math.max(maxDistance, p.dist);
                for (int[] dir : directions) {
                    int curX = p.x + dir[0];
                    int curY = p.y + dir[1];
                    queue.offer(new Point(curX, curY, p.dist+ 1));
                }
            }
        }
        return maxDistance;
    }

//    private int compute(int[][] grid, int n, int i, int j, boolean[][] visited) {
//        Queue<Point> queue = new LinkedList<>();
//        queue.add(new Point(i, j));
//        int minDistance = Integer.MAX_VALUE;
//        int num = 0;
//        while (!queue.isEmpty()) {
//            Point p = queue.poll();
//            if (p.x >= 0 && p.x < n && p.y >= 0 && p.y < n && !visited[p.x][p.y]) {
//                if (grid[p.x][p.y] == 1) {
//                    int distance = Math.abs(p.x - i) + Math.abs(p.y - j);
//                    minDistance = Math.min(minDistance, distance);
//                    num++;
//                }
//                visited[p.x][p.y] = true;
//                queue.offer(new Point(p.x, p.y + 1));
//                queue.offer(new Point(p.x, p.y - 1));
//                queue.offer(new Point(p.x + 1, p.y));
//                queue.offer(new Point(p.x - 1, p.y));
//
//            }
//        }
//        if (num == 0)
//            return -1;
//        else
//            return minDistance;
//    }


    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 1}};
        Solution solution = new Solution();
        System.out.println(solution.maxDistance(grid));
    }

}





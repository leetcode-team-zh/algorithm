package alogrithm.medium;

import java.util.Arrays;

/**
 * @author created by wuwt
 * @date 2020/4/15 9:19 下午
 * 找到矩阵中每个元素到最近0的距离
 **/
public class matrics_542 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return null;
        int[][] dist = new int[matrix.length][matrix[0].length];
        for (int[] x : dist) Arrays.fill(x, Integer.MAX_VALUE - 1000);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    // 左 上
                    if (i > 0) dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0) dist[i][j] = Math.min(dist[i][j], dist[i][j - 1]+1);
                }

            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                //右 下
                if (i < matrix.length - 1) dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < matrix[0].length - 1) dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);

            }
        }
        return dist;

    }
}


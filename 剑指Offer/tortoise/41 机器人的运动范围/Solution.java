package leetcode;

public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visited = new boolean[rows][cols];
        return movingCount(threshold,rows,cols,0,0,visited);
    }

    public int movingCount(int threshold, int rows, int cols,int i,int j,boolean[][] visited){
        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]){
            return 0;
        }

        visited[i][j] = true;
        int flag = 0;
        int fi = i;
        while(fi / 10 != 0){
            flag += fi % 10;
        }

        int fj = j;
        while(fj / 10 != 0){
            flag += fj % 10;
        }

        if(flag <= threshold){
            return  1+ movingCount(threshold,rows,cols,i - 1,j,visited)
                    + movingCount(threshold,rows,cols,i + 1,j,visited)
                    + movingCount(threshold,rows,cols,i,j - 1,visited)
                    + movingCount(threshold,rows,cols,i,j + 1,visited);
        }else{
            return 0;
        }
    }
}
package leetcode;

public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] visited = new boolean[matrix.length];
        for(int  i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(subHasPath(matrix,rows,cols,str,i,j,0,visited))
                    return true;
            }
        }
        return false;
    }

    public boolean subHasPath(char[] matrix, int rows, int cols, char[] str,int i, int j,int k,boolean[] visited){
        int index = i * cols + j;
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || visited[index]){
            return false;
        }

        if(k == str.length - 1){
            return true;
        }

        visited[index] = true;
        //上下左右
        if(subHasPath(matrix,rows,cols,str,i - 1,j,k + 1,visited)
                || subHasPath(matrix,rows,cols,str,i + 1,j,k + 1,visited)
                || subHasPath(matrix,rows,cols,str,i,j - 1,k + 1,visited)
                || subHasPath(matrix,rows,cols,str,i,j + 1,k + 1,visited)){
            return true;
        }
        //回溯
        visited[index] = false;
        return false;

    }
}
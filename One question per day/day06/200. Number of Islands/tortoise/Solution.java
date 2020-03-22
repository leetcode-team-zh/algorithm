package leetcode.d200;

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int nums_island = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    nums_island ++;
                    dfs(grid,grid.length,grid[0].length,i,j);
                }
            }
        }
        return nums_island;
    }

    /**
     * 深度搜索
     * @param grid
     * @param row 行
     * @param column 列
     * @param i
     * @param j
     */
    private void dfs(char[][] grid, int row,int column,int i, int j) {
        if(i < 0 || j < 0 || i >= row || j >= column || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        //搜索左
        dfs(grid,row,column,i - 1,j);
        //搜索下
        dfs(grid,row,column,i, j + 1);
        //搜索右
        dfs(grid,row,column,i,j - 1);
        //搜索上
        dfs(grid,row,column,i + 1,j);
    }
}

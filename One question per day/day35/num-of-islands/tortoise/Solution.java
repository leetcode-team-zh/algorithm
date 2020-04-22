package leetcode.d200;

public class Solution {
    int[] parent;
    int count = 0;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        //初始化
        init(grid);

        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    //标记点，向四周扩散，如果周围存在，且为陆地
                    //比较并且连接两块陆地
                    //上
                    if(i - 1 >= 0 && grid[i - 1][j] == '1'){
                        union(i * n + j, (i - 1) * n + j);
                    }
                    //下
                    if(i + 1 < m && grid[i + 1][j] == '1'){
                        union(i * n + j , (i + 1) * n + j);
                    }

                    //左
                    if(j - 1 >= 0 && grid[i][j - 1] == '1'){
                        union(i * n + j , i * n + j - 1);
                    }

                    //右
                    if(j + 1 < n && grid[i][j + 1] == '1'){
                        union(i * n + j , i * n + j + 1);
                    }
                }
            }
        }
        return count;
    }

    public void init(char[][] grid){
        count = 0 ;
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        for(int i = 0 ; i < m ;i++){
            for(int j = 0; j < n; j++ ){
                if(grid[i][j] == '1'){
                    parent[i * n + j] = i * n + j;
                    ++ count;
                }
            }
        }
    }

    public int find(int i){
        if(parent[i] != i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x,int y){
        int rootx = find(x);
        int rooty = find(y);

        if(rootx != rooty){
            parent[rooty] = rootx;
            --count;
        }
    }

    public int numIslands1(char[][] grid) {
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

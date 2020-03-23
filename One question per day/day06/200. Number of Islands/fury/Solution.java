class Solution {
    /*
    * import javax.swing.tree.TreeNode;
    * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    *  You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
     */

    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid == null || grid.length==0) return num;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    traversal(grid, row, col, i, j, visited);
                    num++;
                }
            }
        }
        return num;
    }

    private void traversal(char[][] grid, int row, int col, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            return;
        } else {
            if (!visited[i][j]) {
                visited[i][j] = true;
                traversal(grid, row, col, i - 1, j, visited);
                traversal(grid, row, col, i + 1, j, visited);
                traversal(grid, row, col, i, j - 1, visited);
                traversal(grid, row, col, i, j + 1, visited);
            }

        }
    }


    public static void main(String[] args) {
        /*
        11000
11000
00100
00011
        * */
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1','0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0','0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid2));
    }


}

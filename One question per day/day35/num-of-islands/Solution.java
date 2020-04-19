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

 static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0) return 0;
        int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0));
        int sum = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (inArea(m, n, p.x, p.y) && !visited[p.x][p.y] &&
                    sumOfDigits(p.x) + sumOfDigits(p.y) <= k) {
                visited[p.x][p.y] = true;
                for (int[] dir : direction) {
                    int curX = p.x + dir[0];
                    int curY = p.y + dir[1];
                    queue.offer(new Point(curX, curY));
                }
                sum++;
            }
        }
        return sum;
    }

    private int sumOfDigits(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }

    private boolean inArea(int row, int col, int i, int j) {
        if (i < 0 || i >= row) return false;
        return j >= 0 && j < col;
    }

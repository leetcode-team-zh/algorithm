package leetcode.m13;

public class Solution {
    int count = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(0,0,m,n,k,visited);
        return count;
    }

    private void dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if(i >= m || i < 0 || j >= n || j < 0 || getNumericalDigit(i) + getNumericalDigit(j) > k || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        count ++;
        //往下
        dfs(i,j + 1,m,n,k,visited);
        //往右
        dfs(i + 1,j,m,n,k,visited);
    }

    //获取一个整数的数位和
    private int getNumericalDigit(int num){
        int res = 0;
        while(num > 0){
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(1,2,1));
    }
}

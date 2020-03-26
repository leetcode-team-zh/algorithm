package leetcode.d999;

public class Solution {
    int nums = 0;

    public int numRookCaptures(char[][] board) {
        if(board == null || board.length == 0){
           return 0;
        }

        for(int i = 0 ; i < 8; i++){
            for(int j =0 ; j < 8 ;j ++){
                if(board[i][j] == 'R'){
                    //左
                    dfs(board,i - 1,j, -1 ,0);
                    //下
                    dfs(board,i,j+1,0 ,1);
                    //右
                    dfs(board,i + 1,j , 1, 0);
                    //上
                    dfs(board,i,j - 1, 0, -1);
                }
            }
        }
        return nums;
    }

    private void dfs(char[][] board, int i, int j,int dx, int dy) {
        if(i < 0 || i >= 8 || j < 0|| j >=8 || board[i][j] == 'B'){
            return;
        }
        if(board[i][j] == 'p'){
            nums ++;
            return;
        }
        //一直走
        dfs(board,i + dx,j + dy,dx,dy);
    }

    public static void main(String[] args) {
        new Solution().numRookCaptures(
                new char[][]{
                        {'.','.','.','.','.','.','.','.'},
                        {'.','.','.','p','.','.','.','.'},
                        {'.','.','.','p','.','.','.','.'},
                        {'p','p','.','R','.','p','B','.'},
                        {'.','.','.','.','.','.','.','.'},
                        {'.','.','.','B','.','.','.','.'},
                        {'.','.','.','p','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.'}});
    }
}

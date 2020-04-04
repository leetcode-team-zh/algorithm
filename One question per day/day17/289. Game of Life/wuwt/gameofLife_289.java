package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/4 10:09 下午
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 **/
public class gameofLife_289 {
    public void gameOfLife(int[][] board) {
        /*
        Dead->Dead: Condition 0;
        Live->Live : Condition 1;
        Live->Dead: Condition 2;
        Dead->Live:Condition 3
         */
        int row = board.length;
        int col = board[0].length;

        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                int count = getLive(board,i,j) ;//计算原来8个位置有多少活细胞
                if(board[i][j]==0||count==3){ //dead->live
                    board[i][j] =3;
                }else if(board[i][j]==1 &&(count<2||count>3)){//live->dead
                    board[i][j]=2;
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j] = board[i][j]%2;
            }
        }

    }
    //计算原来周围的8个位置上有多少个活细胞
    public int getLive(int[][] board,int i,int j){
        int count =0;
        for(int x =i-1;x<=i+1;x++){
            for(int y =j-1;y<=j+1;y++){
                if(x<0 || x>=board.length || y<0||y>=board[0].length || (x==i &&y==j))
                    continue;

                if(board[x][y]==1||board[x][y]==2)
                    count+=1;
            }
        }

        return count;
    }
}


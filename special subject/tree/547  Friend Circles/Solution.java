package leetcode.d547;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        new Solution().findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}});
    }
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFindSet unionFindSet = new UnionFindSet(n);

        for(int i =0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(M[i][j] ==1){
                    unionFindSet.union(i,j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n; i++){
            set.add(unionFindSet.find(i));
        }

        return set.size();
    }

    public class UnionFindSet{
        int[] parents;
        public UnionFindSet(int size){
            parents = new int[size];

            for(int i =0 ; i < size; i++){
                parents[i] = i;
            }
        }

        public void union(int root1,int root2){
            int x = find(root1);
            int y = find(root2);
            if(x != y){
                parents[x] = y;
            }
        }

        public int find(int root){
            int son = root;
            while(root != parents[root]){
                root = parents[root];
            }

            //路径压缩
            while(son != root){
                int tmp = parents[son];
                parents[son] = root;
                son = tmp;
            }
            return root;
        }
    }
}

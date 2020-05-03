package leetcode.d684;

public class Solution {

    public static void main(String[] args) {
        new Solution().findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}});
    }

    public int[] findRedundantConnection(int[][] edges) {
        //初始化并查集
        UnionFindSet unionFindSet = new UnionFindSet(edges.length);

        for(int[] edge : edges){
            if(!unionFindSet.union(edge[0],edge[1])){
                return edge;
            }
        }

        return new int[]{};
    }


    public class UnionFindSet{
        int[] parents;

        public UnionFindSet(int size){
            parents = new int[size + 1];
            for(int i = 0; i <= size ; i++){
                this.parents[i] = i;
            }
        }

        //并
        public boolean union(int root1,int root2){
            int x = find(root1);
            int y = find(root2);
            if(x != y){
                parents[x] = y;
                return true;
            }else {
                return false;
            }
        }

        //查 a[0]=0 a[1]=1 a[2]=1 a[3]=2 a[4]=3
        public int find(int root){
            int son = root;
            while(root != parents[root]){
                root = parents[root];
            }
            //路径压缩
            while (son != root){
                int tmp = parents[son];
                parents[son] = root;
                son = tmp;
            }
            return root;
        }

    }

}

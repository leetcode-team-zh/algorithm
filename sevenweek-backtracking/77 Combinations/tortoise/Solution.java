package leetcode.d77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n <= 0 || k <= 0){
            return result;
        }
        dfs(n,k,1,new ArrayList<>(),result);
        return result;
    }

    private void dfs(int n, int k, int index, List<Integer> tmpList,List<List<Integer>> result) {
        if(tmpList.size() == k){
            result.add(new ArrayList<>(tmpList));
            return;
        }

        for(int i = index ; i <= n ; i++){
            tmpList.add(i);
            dfs(n,k,i + 1,tmpList,result);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution().combine(4,2);
    }
}

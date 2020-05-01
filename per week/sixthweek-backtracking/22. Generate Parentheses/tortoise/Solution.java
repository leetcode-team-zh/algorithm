package leetcode.d22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0){
            return  result;
        }
        dfs(n,n,"",result);
        return result;
    }

    private void dfs(int left, int right, String tmp,List<String> result) {
        if (left == 0 && right == 0){
            result.add(tmp);
            return;
        }

        if(left > right){
            return;
        }else {
            if(left > 0){
                dfs(left - 1,right,tmp + "(" ,result);
            }

            if(right > 0){
                dfs(left,right - 1,tmp + ")" ,result);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

}

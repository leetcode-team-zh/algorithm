package leetcode;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1){
            return -1;
        }

        List<Integer> list = new ArrayList<>();
        //初始化
        for(int i =0 ; i < n; i++){
            list.add(i);
        }

        int cur = -1;
        while(list.size() > 1){
            for(int i = 0;i < m;i++){
                cur++;
                if(cur == list.size()){
                    cur = 0;
                }
            }
            list.remove(cur);
            cur --;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        new Solution().LastRemaining_Solution(5,3);
    }
}

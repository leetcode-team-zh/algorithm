package leetcode.d1248;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //存放奇数的索引，增加两个边界
        List<Integer> oddIndex = new ArrayList<>();
        oddIndex.add(-1);

       for(int i = 0 ; i < nums.length ; i++){
           if(nums[i] % 2 == 1){
               oddIndex.add(i);
           }
       }
       oddIndex.add(nums.length);

       int result = 0;
       for(int i = 1; i + k < oddIndex.size() ; i++ ){
           result += (oddIndex.get(i) -  oddIndex.get(i -1)) * (oddIndex.get(i + k) - oddIndex.get(i + k -1));
       }

       return result;
    }
}

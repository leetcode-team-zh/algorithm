package leetcode;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array){
        int votes = 0;
        int target = array[0];
        for(int num : array){
            if(votes == 0){
                target = num;
            }
            if(num == target){
                votes += 1;
            }else{
                votes -= 1;
            }
        }

      int count = 0;
      for(int num : array){
          if(num == target){
              count ++;
          }
      }

        return count > array.length / 2 ? target : 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().MoreThanHalfNum_Solution(new int[]{1,2,3,2,4,2,5,2,3}));
    }
}

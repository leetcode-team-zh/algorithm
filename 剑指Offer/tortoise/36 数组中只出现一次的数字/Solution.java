package leetcode;

public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int x = 0;
        for(int i = 0 ; i < array.length; i++){
            x = x ^ array[i];
        }

        int index = 1;
        while((index & x)==0)
            index = index << 1;//因为可能有多个位为1所以需要求一下位置

        int result1 = 0;
        int result2 = 0;
        for(int a : array){
            if((index & a) == 0)
                result1 = result1^a;
            else
                result2 = result2^a;
        }
        num1[0] = result1;
        num2[0] = result2;
    }
}
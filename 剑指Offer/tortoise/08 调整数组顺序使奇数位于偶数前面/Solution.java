package leetcode;


public class Solution {
    public void reOrderArray(int [] array) {
        int len = array.length;
        if(len <= 1){ // 数组空或长度为1
            return;
        }

        int i = 0;
        while(i < len){
            int j = i + 1;
            if(array[i] % 2 == 0){ // a[i]为偶数，j前进，直到替换
                while(array[j]%2 == 0){ // j为偶数，前进
                    if(j == len-1)// i为偶数，j也为偶数，一直后移到了末尾，证明后面都是偶数
                        return;
                    j++;
                }
                // 此时j为奇数
                int count = j-i;
                int temp = array[i];
                array[i] = array[j];
                while(count>1){
                    array[i+count] = array[i+count-1];//数组后移
                    count--;
                }
                array[i+1] = temp;
            }
            i++;
        }
    }
}

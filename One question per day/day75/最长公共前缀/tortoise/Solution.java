package leetcode.d14;

public class Solution {
    //分治法
    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }else{
            return longestCommonPrefix(strs,0,strs.length - 1);
        }
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if(left == right){
            return strs[left];
        }else{
            int mid = left + (right - left)/2;
            String lcpLeft = longestCommonPrefix(strs,left,mid);
            String lcpRight = longestCommonPrefix(strs,mid + 1,right);
            return commonPrefix(lcpLeft,lcpRight);
        }
    }

    private String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }
}

package leetcode.d151;

public class Solution {
    public String reverseWords(String s) {
       if(s == null || s.length() == 0){
           return s;
       }

       String[]  arr = s.split(" ");
       StringBuilder builder = new StringBuilder();
       for(int i = arr.length - 1; i >= 0 ; i --){
           if(arr[i].length() > 0){
               builder.append(arr[i] + " ");
           }
       }
       return builder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("a good   example"));
    }

}

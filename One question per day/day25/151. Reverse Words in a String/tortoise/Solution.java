package leetcode.d151;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        List<String> list = new ArrayList<>();

        s = s.trim();
        int length = s.length();
        int i = length - 1;
        int j = length - 1;
        while (i >= 0){
            while(i >= 0 && s.charAt(i) != ' ') i--;
            list.add(s.substring(i + 1,j + 1));
            while (i >=0 && s.charAt(i) == ' ') i--;
            j = i;
        }

        String result = "";
        result = result.join(" ",list);
        return result;
    }

    public String reverseWords1(String s) {
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

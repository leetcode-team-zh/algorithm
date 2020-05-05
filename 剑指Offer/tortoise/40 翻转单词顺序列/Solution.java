package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String ReverseSentence(String str) {
        if(str == null){
            return str;
        }

        String trimStr = str.trim();
        if(trimStr.length() == 0){
            return str;
        }


        int  i = trimStr.length() - 1;
        int  j = i;

        //String result = "";
        List<String> list = new ArrayList<>();
        //I am a student.
        while(i >= 0){
            while(i >=0 && trimStr.charAt(i) != ' '){
                i--;
            }

            list.add(trimStr.substring(i + 1,j + 1));
//            result = result + " " +  str.substring(i + 1,j);
            while(i >=0 && trimStr.charAt(i) == ' '){
                i--;
            }
            j = i;
        }
        return String.join(" ",list);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().ReverseSentence("student. a am I"));
    }
}
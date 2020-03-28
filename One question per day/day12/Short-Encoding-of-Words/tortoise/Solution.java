package leetcode.d820;

import java.util.*;

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        if(words.length == 0){
            return 0;
        }
        List<String> reverseWords = new ArrayList<>();
        //反转
        for(String word : words){
            reverseWords.add(new StringBuilder(word).reverse().toString());
        }
        //按字母排序
        Collections.sort(reverseWords);

        int count = 0;
        //me -> em ,time -> emit,stime -> emits,hello -> olleh
        for(int i = 0 ; i < reverseWords.size() - 1;i++){
            if(!reverseWords.get(i + 1).startsWith(reverseWords.get(i))){
                count += reverseWords.get(i).length() + 1;
            }
        }
        //加上最后一个
        count += reverseWords.get(reverseWords.size() - 1).length() + 1;
        return count;
    }
}

package leetcode.d187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }

        Map<String,Integer> map = new HashMap<>();
        int window = 10;
        int l = 0;
        int r = window;

        while(r <= s.length()){
            String tmp = s.substring(l,r);
            map.compute(tmp,(k,v) -> {
                if(v == null){
                    return 1;
                }else{
                    if(v == 1) {
                        result.add(tmp);
                    }
                    return v + 1;
                }
            });
            l++;
            r++;
        }
        return result;
    }


    public static void main(String[] args) {
        new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}

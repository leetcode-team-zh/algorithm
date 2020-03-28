package com.dpc.algorithm;


import java.util.Arrays;
import java.util.Comparator;

class Solution {
    /*
    * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.

For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].

Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.

What is the length of the shortest reference string S possible that encodes the given words?
    * */

    public int minimumLengthEncoding(String[] words) {
        if (words == null | words.length == 0) return 0;
        String[] strs = new String[words.length];
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for (int i = 0; i < words.length; i++) {
            if (i == 0) strs[i] = words[i] + '#';
            else {
                int index = strs[i - 1].indexOf(words[i]);
                if (index != -1) { // 看能否匹配到#
                    if (strs[i - 1].charAt(index + words[i].length()) == '#') {
                        strs[i] = strs[i - 1];
                        continue;
                    }
                }
                strs[i] = strs[i - 1] + words[i] + '#';
            }
        }
        return strs[words.length - 1].length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"time", "me", "ime"};
        System.out.println(solution.minimumLengthEncoding(words));
    }

}





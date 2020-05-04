package leetcode;


import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0){
            return new ArrayList<>();
        }

        Set<String> set = new HashSet<>();
        char[] strChars = str.toCharArray();
        boolean[] visited = new boolean[str.length()];
        dfs(strChars,visited,"",set);
        ArrayList<String > result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    private void dfs(char[] strChars, boolean[] visited, String s, Set<String> set){
        if(s.length() == strChars.length){
            set.add(s);
        }

        for(int i = 0; i < strChars.length ; i++){
            if(visited[i]){
                continue;
            }

            visited[i] =  true;
            dfs(strChars,visited,s + strChars[i],set);
            visited[i] = false;
        }
    }
}

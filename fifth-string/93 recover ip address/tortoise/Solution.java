package leetcode.d93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if(s == null || s.length() < 3 || s.length() > 12){
            return result;
        }
        
        dfs(s,0,"",0,result);
        //回溯法
        return result;

    }

    /**
     *
     * @param s 原始的字符串
     * @param index 字符串的位置
     * @param tmp 临时的字符串
     * @param n 当前层数
     * @param result 结果集合
     */
    private void dfs(String s, int index, String tmp, int n, List<String> result) {
        if(n >= 4){
            if(index == s.length()){
                //去掉结尾多余的 "."
                result.add(tmp.substring(0,tmp.length() - 1));
            }
            return;
        }

        for(int i = index  + 1 ;  i <= s.length() ; i++){
            if(isNum(s.substring(index,i))){
                dfs(s,i,tmp + s.substring(index,i) + ".",n + 1,result);
            }else{
                break;
            }
        }
    }

    //判断是否为合法数字
    private boolean isNum(String s){
        int num = Integer.valueOf(s);
        //除非单独的0，不然数字不能以0开头
        return num >= 0 && num <= 255 && String.valueOf(num).equals(s);
    }

    public static void main(String[] args) {
        new Solution().restoreIpAddresses("25525511135");
    }

}

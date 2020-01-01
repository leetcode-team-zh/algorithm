package leetcode.d17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private String[] lettersArr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return result;
        }

        dfs(digits.toCharArray(),0,"",result);
        return result;
    }

    /**
     *
     * @param digits 数字
     * @param index 数字的下标
     * @param tmp 临时的字符串
     * @param result 结果集合
     */
    private void dfs(char[] digits, int index, String tmp, List<String> result) {
        //退出条件
        if(index == digits.length){
            result.add(tmp);
            return;
        }

        //当前数字
        char digit = digits[index];
        String letters = lettersArr[digit - '0'];
        char[] letterArr = letters.toCharArray();
        for(char c : letterArr){
            dfs(digits,index + 1 , tmp + c ,result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}

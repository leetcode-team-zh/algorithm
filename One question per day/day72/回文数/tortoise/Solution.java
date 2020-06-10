package leetcode.d9;

public class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder stringBuilder = new StringBuilder(x + "");
        String str = stringBuilder.toString();
        String reverseStr = stringBuilder.reverse().toString();
        return str.equals(reverseStr);
    }

    public static void main(String[] args) {
        new Solution().isPalindrome(-121);
    }
}

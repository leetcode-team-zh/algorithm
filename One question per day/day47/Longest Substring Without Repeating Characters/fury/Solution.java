import java.util.HashSet;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = Integer.MIN_VALUE;
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        char[] chs = s.toCharArray();
        while (left <= right && right < s.length()) {
            if (set.contains(chs[right])) {
                while (chs[left] != chs[right]) {
                    set.remove(chs[left++]);
                }
                set.remove(chs[left++]);

            } else {
                maxLen = Math.max(maxLen, right - left + 1);
                set.add(chs[right++]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "abcde";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s1));
    }
}


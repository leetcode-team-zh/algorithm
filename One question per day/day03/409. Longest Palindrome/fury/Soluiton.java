
class Solution {
    /*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */


    public int longestPalindrome(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (count.containsKey(c)) {
                int n = count.get(c);
                count.put(c, n + 1);
            } else {
                count.put(c, 1);
            }
        }
        boolean once = false;
        int num = 0;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                if (once) continue;
                else {
                    num++;
                    once = true;
                }
            } else {
                int n = entry.getValue();
                if (n % 2 == 0) num += n;
                else {
                    if (once) {
                        num += (n - 1);
                    } else {
                        num += n;
                        once=true;
                    }
                }
            }

        }
        return num;
    }

    public static void main(String[] args) {
        String s = "bananas";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(s));
    }


}

package leetcode.d1160;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        int[] charCount = new int[26];
        for(char c : chars.toCharArray()){
            charCount[c - 'a'] += 1;
        }

        for(String str :  words){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a'] += 1;
            }
            int i = 0;
            for(i = 0 ; i < 26; i++){
                if(count[i] > charCount[i]){
                    break;
                }
            }
            if(i == 26){
                result += str.length();
            }else {
                continue;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String s = "atach";
        Solution solution = new Solution();
        solution.countCharacters(words,s);
    }
}


package com.dpc.algorithm;


import java.util.HashMap;
import java.util.Map;

class Solution {

     /*
     * Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false´
Explanation: No possible partition.
Example 3:

Input: deck = [1]
Output: false
Explanation: No possible partition.*/

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
        int g = -1;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (g == -1) {
                g = entry.getValue();
            } else {
                g = gcd(g, entry.getValue());
            }
        }
        return g >= 2;
    }

    private int gcd(int x, int y) {
        if (x == 0) return y;
        else return gcd(y % x, x);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] decks = {11,11,11};
        System.out.println(solution.hasGroupsSizeX(decks));
    }


}





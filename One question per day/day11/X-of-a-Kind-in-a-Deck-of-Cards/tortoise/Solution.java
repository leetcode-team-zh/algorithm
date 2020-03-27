package leetcode.d914;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck == null || deck.length < 2){
            return false;
        }

        Map<Integer,Integer> countMap = new HashMap<>();
        for(int num : deck){
            countMap.compute(num,(k,v) ->{
                if(v == null){
                    v = 1;
                }else {
                    v += 1;
                }
                return v;
            });
        }

        final int[] g = {-1};
        countMap.values().forEach(count -> {
            if(g[0] == -1){
                g[0] = count;
            }else {
                g[0] = gcd(count,g[0]);
            }
        });
        return g[0] >= 2;
    }

    /**
     *  求x,y 的最大公约数
     */
    private int gcd(int m,int n){
        int rem;
        while(n > 0){
            rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static void main(String[] args) {
        new Solution().hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1});
    }
}

package leetcode.m62;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++ ){
            list.add(i);
        }

        int index = 0;
        int size = list.size();
        while (size > 1){
            index =  (index + (m - 1)) % size;
            list.remove(index);
            size--;
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        new Solution().lastRemaining(10,17);
    }
}

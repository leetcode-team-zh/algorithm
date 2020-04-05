package com.dpc.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    static class Item {
        int val;
        int fre;

        public Item(int val, int fre) {
            this.val = val;
            this.fre = fre;
        }

    }

    static class LFUCache {

        /**
         * Your LFUCache object will be instantiated and called as such:
         * LFUCache obj = new LFUCache(capacity);
         * int param_1 = obj.get(key);
         * obj.put(key,value);
         */

        private int capacity;
        private int minFre; // 出现的最小频率
        private HashMap<Integer, Item> map; //key对value索引
        private HashMap<Integer, LinkedList<Integer>> fre; // key出现频率索引

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.fre = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            // 更新频率，返回值
            Item item = map.get(key);
            // 找到频率列表，删除元素
            LinkedList<Integer> oldFreList = fre.get(item.fre);
            oldFreList.remove(Integer.valueOf(key));
            // 对应新的频率列表添加元素
            LinkedList<Integer> newFreList = fre.computeIfAbsent(item.fre + 1, k -> new LinkedList<>());
            newFreList.addLast(key);
            item.fre++;
            //如果freq中频率为minFreq的list为空，minFreq自增1
            if (fre.get(minFre) == null || fre.get(minFre).size() == 0) minFre++;

            return item.val;
        }

        public void put(int key, int value) {

            if (capacity <= 0) return;
            if (map.containsKey(key)) {
                if (get(key) != -1) //更新也算访问一次
                    map.get(key).val = value;
                return;
            }


            if (map.size() == capacity) {
                LinkedList<Integer> minList = fre.get(minFre);
                int k = minList.removeFirst();
                map.remove(k);
            }
            map.put(key, new Item(value, 0));
            LinkedList<Integer> minList = fre.computeIfAbsent(0, k -> new LinkedList<>());
            minList.addLast(key);
            minFre = 0;
        }


    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));    // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));    // returns -1 (not found)
//        System.out.println(cache.get(3));     // returns 3.
//        cache.put(4, 4);    // evicts key 1.
//        System.out.println(cache.get(1));    // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));      // returns 4


        /*
        * ["LFUCache","put","put","get","get","get","put","put","get","get","get","get"]
[[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]*/
//        cache.put(2, 2);
//        cache.put(1, 1);
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//        cache.put(3, 3);
//        cache.put(4, 4);
//        System.out.println(cache.get(3)); // 从这里还是出错
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(4));

//       ["LFUCache","put","put","put","put","get","get"]
//[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));  //return -1
        System.out.println(cache.get(2)); // return 3

    }

}


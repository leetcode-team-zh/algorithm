package alogrithm.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author created by wuwt
 * @date 2020/4/8 10:46 下午
 **/
public class LFUCache_60 {
    Map<Integer,Integer> valMap;
    Map<Integer,Integer> freqMap;
    Map<Integer, LinkedHashSet<Integer>> kSetMap ;
    int size;
    int min;
    public LFUCache_60(int capacity){
        min =0;
        size = capacity;
        valMap = new HashMap<>();
        freqMap = new HashMap<>();
        kSetMap = new HashMap<>();
        kSetMap.put(1,new LinkedHashSet<>());
    }

    public int get(int key ){
        if(!valMap.containsKey(key)) return -1;
        // 经常访问的元素
        int frequency = freqMap.get(key);
        freqMap.put(key,frequency+1);
        kSetMap.get(frequency).remove(key);
        if(!kSetMap.containsKey(frequency+1)){
            kSetMap.put(frequency+1,new LinkedHashSet<>());
        }
        kSetMap.get(frequency+1).add(key);
        if(min==frequency&&kSetMap.get(frequency).size()==0){
            min++;
        }
        return valMap.get(key);
    }

    public void put(int key,int val){
        if(size<=0) return;
        if(valMap.containsKey(key)){
            valMap.put(key,val);
            get(key);
            return ;
        }
        if(valMap.size()==min){
            int minKey = kSetMap.get(min).iterator().next();
            valMap.remove(minKey);
            freqMap.remove(minKey);
            kSetMap.get(min).remove(minKey);
        }
        valMap.put(key,val);
        freqMap.put(key,1);
        kSetMap.get(1).add(key);

    }
}


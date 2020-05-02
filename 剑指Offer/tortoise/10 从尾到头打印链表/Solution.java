package leetcode;


import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if(listNode == null){
            return result;
        }
        while(listNode != null){
            result.add(0,listNode.val);
            listNode = listNode.next;
        }
        return result;
    }
}

package leetcode;


import java.util.Stack;

public class Solution {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack();
    public void push(int node) {
        data.push(node);
        if(!min.isEmpty()){
            int currentMin = min.peek();
            if(node <= currentMin){
                min.push(node);
            }
        }else{
            min.push(node);
        }
    }

    public void pop() {
        int o = data.pop();
        if(o == min.peek()){
            min.pop();
        }
    }

    public int top() {
        if(data.isEmpty()){
            return -1;
        }
        return data.peek();
    }

    public int min() {
        if(min.isEmpty()){
            return -1;
        }
        return min.peek();
    }
}

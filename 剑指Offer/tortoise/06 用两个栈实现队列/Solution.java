package leetcode;

import java.util.Stack;

public class Solution {
    //入栈
    Stack<Integer> stack1 = new Stack<Integer>();
    //出栈
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            //1.将入栈放到出栈
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        if(stack2.isEmpty()){
            return -1;
        }else{
            return stack2.pop();
        }
    }
}

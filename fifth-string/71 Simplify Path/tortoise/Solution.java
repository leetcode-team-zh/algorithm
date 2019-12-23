package leetcode.d71;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return path;
        }
        Stack<String> stack = new Stack<>();

        String[] pathArr = path.split("\\/");
        for(String pathStr : pathArr){
            if(pathStr.equals("..") && !stack.isEmpty()){
                stack.pop();
            }else if(pathStr.length() != 0 && !pathStr.equals("..") && !pathStr.equals(".")){
                stack.push(pathStr);
            }
        }

        String result = "";
        while (!stack.isEmpty()){
            String str = stack.pop();
            result = "/" + str + result;
        }

        if(result.length() == 0){
            result = "/";
        }
        return result;
    }

    public static void main(String[] args) {
//        new Solution().simplifyPath("/home/");
 //       new Solution().simplifyPath("/home//foo/");
        new Solution().simplifyPath("/../");
    }
}

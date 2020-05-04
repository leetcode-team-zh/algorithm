package leetcode;


import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }

        return isSymmetrical(pRoot.left,pRoot.right);
    }


    private boolean isSymmetrical(TreeNode leftNode,TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }else if(leftNode != null && rightNode != null && leftNode.val == rightNode.val){
            return isSymmetrical(leftNode.left,rightNode.right);
        }else{
            return false;
        }
    }
}

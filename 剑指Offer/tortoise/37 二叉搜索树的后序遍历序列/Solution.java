package leetcode;

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }

        //5,7,6,9,11,10,8
        return VerifySquenceOfBST(sequence,0,sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence,int begin,int end){
        if(begin > end){
            return false;
        }

        int i = begin;
        for(;i < end; i++){
            if(sequence[i] > sequence[end]){
                break;
            }
        }


        int j = i;
        for(;j < end;j++){
            if(sequence[j] < sequence[end]){
                return false;
            }
        }

        boolean left = true;
        if(i > begin){
            left = VerifySquenceOfBST(sequence,begin,i - 1);
        }

        boolean right = true;
        if(i < end - 1){
            right = VerifySquenceOfBST(sequence,i,end - 1);
        }

        return left && right;
    }
}
public class Solution {
    public int JumpFloorII(int target) {
        if(target == 1)
            return 1;
        int i1 = 1;
        for(int i = 1; i < target;i++){
            int tmp = 2 * i1;
            i1 = tmp;
        }
        return i1;
    }
}
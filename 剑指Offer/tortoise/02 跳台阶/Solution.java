public class Solution {
    public int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        int i1 = 1 ;
        int i2 = 1;
        for(int i = 1; i < target; i++){
            int tmp = i1 + i2;
            i1 = i2;
            i2 = tmp;
        }
        return i2;
    }
}
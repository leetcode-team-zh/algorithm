package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/18 10:58 上午
 * 使用最少的步数到达最后一个位置
 * 贪心算法，计算到达每一步需要的step
 **/
public class jump_45 {
    public int jump(int[] nums) {
        int end =0;
        int maxPos =0;
        int step =0;
        // 如果是 i < nums.length，i 遍历到最后的时候，会进入 if 语句中，steps 会多加 11。
        for(int i=0;i<nums.length-1;i++){
            maxPos = Math.max(maxPos,nums[i]+i);
            if(end ==i){
                end = maxPos;
                step ++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int nums[] =  {2,3,1,1,4};
        System.out.println(new jump_45().jump(nums));
    }
}


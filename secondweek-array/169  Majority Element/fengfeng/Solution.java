class Solution {
    public int majorityElement(int[] nums) {
        int maj = 0;
        int count = 0;
        for(int n=0;n<nums.length ;n++){
            if(count == 0){
                count = 1;
                maj = nums[n];
            }else{
                if(nums[n] != maj){
                    count--;
                }else{
                    count++;
                }
            }
        }
        return maj;
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        solve(nums,0);
        return results;
    }


    private List<List<Integer>> results;
    private void solve(int[] nums,int cur){
        if(cur == nums.length){
            List<Integer> res = new ArrayList<>(nums.length);
            for(int v:nums){
                res.add(v);
            }
            results.add(res);
            return;
        }

        for(int n=cur;n<nums.length;n++){
            swap(nums,cur,n);
            solve(nums,cur+1);
            swap(nums,cur,n);
        }
    }

    private void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

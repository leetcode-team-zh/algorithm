
class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        solve(nums,0,new ArrayList<Integer>());
        return res;
    }
    private void solve(int[] nums,int cur,List<Integer> tmp){
        if(cur == nums.length){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        solve(nums,cur+1,tmp);
        tmp.add(nums[cur]);
        solve(nums,cur+1,tmp);
        tmp.remove(tmp.size()-1);
    }
}

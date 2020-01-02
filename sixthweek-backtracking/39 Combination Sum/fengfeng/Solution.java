class Solution {
List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target <= 0 ){
            return results;
        }
        sum(target,candidates,0,new ArrayList<Integer>());
        return results;
    }
    private void sum(int target,int[] candidates,int cur,List<Integer> res){
        if(target == 0){
            ArrayList<Integer> cr = new ArrayList<Integer>(res);
            results.add(cr);
            return;
        }
        if(cur >= candidates.length){
            return;
        }

        sum(target,candidates,cur+1,res);
        int count = 1;
        while(target  >= count * candidates[cur]){
            for(int n=0;n<count;n++){
                 res.add(candidates[cur]);
            }
            sum(target - count*candidates[cur],candidates,cur+1,res);
            for(int n=0;n<count;n++){
                res.remove(res.size() - 1);
            }
            count++;
        }


    }
}

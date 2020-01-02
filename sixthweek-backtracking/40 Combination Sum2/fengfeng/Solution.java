class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
          if(target <= 0 ){
            return results;
        }
        Arrays.sort(candidates);
        sum(target,candidates,0,new ArrayList<Integer>());
        return results;
    }

   
List<List<Integer>> results = new ArrayList<>();


    private void sum(int target,int[] candidates,int cur,List<Integer> res){
        if(target == 0){
            ArrayList<Integer> cr = new ArrayList<Integer>(res);
            results.add(cr);
            return;
        }
        if(cur >= candidates.length){
            return;
        }

        int count = 0;
        int num = candidates[cur];
          
        while(cur < candidates.length && candidates[cur] == num){
                cur++;
                count++;
        }

        int c = 0;
        

        while(target  >= num * c && c <= count){
          for(int n=0;n<c;n++){
            res.add(num);
          }
            sum(target - num*c,candidates,cur,res);
           for(int n=0;n<c;n++){
            res.remove(res.size() - 1);
           }
            c++;
        }

 


    }

}

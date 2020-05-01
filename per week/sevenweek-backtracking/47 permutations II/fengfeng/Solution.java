class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        solve(map,0,nums.length,new ArrayList<Integer>(nums.length));
        return res;
    }
    List<List<Integer>> res = new ArrayList<>();
    private void solve(Map<Integer,Integer> map,int cur,int size,List<Integer> l){
        if(cur == size){
            res.add(new ArrayList<Integer>(l));
            return;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int value = entry.getValue();
            if(value == 0){
                continue;
            }

            map.put(entry.getKey(),value - 1);

            l.add(entry.getKey());
            solve(map,cur+1,size,l);

            map.put(entry.getKey(), value);
            l.remove(l.size() - 1);

        }

    }

}

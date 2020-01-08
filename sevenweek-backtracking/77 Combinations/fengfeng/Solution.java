class Solution {

    private List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        if(k == 0 ){
            return null;
        }
        solve(n,1,k,new ArrayList<Integer>());
        return res;
    }
    private void solve(int n,int cur,int k,List<Integer> l){
        if(n - cur + 1 == k ){
            List<Integer> tmp = new ArrayList<>(l);
            for(int m =cur;m<=n;m++){
                tmp.add(m);
            }
            res.add(tmp);
            return ;
        }else if(k == 0){
            res.add(new ArrayList<Integer>(l));
            return;
        }
        solve(n,cur+1,k,l);

        l.add(cur);
        solve(n,cur+1,k-1,l);
        l.remove(l.size() -1);
    }
}

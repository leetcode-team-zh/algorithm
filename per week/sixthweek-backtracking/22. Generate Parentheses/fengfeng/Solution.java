class Solution {
    private List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        solve(n,0,0,"");
        return result;
    }

    private void solve(int n,int leftCount,int rightCount,String s){
        if(leftCount == n){
            for(int m=rightCount;m<n;m++){
                s = s+")";
            }
            result.add(s);
            return;
        }

        solve(n,leftCount+1,rightCount,s+"(");
        if(leftCount != rightCount){
            solve(n,leftCount,rightCount+1,s+")");
        }

    }
}

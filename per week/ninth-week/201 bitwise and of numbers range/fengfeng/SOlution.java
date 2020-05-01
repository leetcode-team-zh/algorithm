class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int num;
        if(m%2==1){
            num = 1;
        }else{
            num = 2;
        }
        int res = m;
        int range = n -m;
        while(num < range && num<=m){
            res = res & (num+m);
            num = num << 1;
        }
        res = res & n;
        return res;

    }
}

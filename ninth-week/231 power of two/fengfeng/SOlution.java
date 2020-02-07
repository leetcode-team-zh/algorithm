class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        int num=1;
        int count =0;
        while(num!= n && count < 32){
            num = num<<1;
            count++;
        }
        if(num == n){
            return true;
        }
        return false;

    }
}

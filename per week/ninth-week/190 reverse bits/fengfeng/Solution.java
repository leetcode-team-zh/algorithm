public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for(int m=0;m<16;m++){
            int low = n & (1<< m);
            int high = n & (1<<(31-m));
            if(high != 0){
                n = n | (1<<m);
            }else{
                n = n & ~(1<<m);
            }
            if(low !=0){
                n = n | (1<<(31-m));
            }else{
                n = n & ~(1<<(31-m));
            }
        }
        return n;
    }
}

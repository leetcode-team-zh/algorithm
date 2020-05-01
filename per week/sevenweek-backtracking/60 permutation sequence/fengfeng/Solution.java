class Solution {
    public String getPermutation(int n, int k) {
            int base = 1;
        for(int m=2;m<n;m++){
            base *= m;
        }
        int[] a1 = new int[n];
        for(int m=0;m<n;m++){
            a1[m] = m+1;
        }
        StringBuilder builder = new StringBuilder();
        int count = 0;
        while(k != 0 ){
            int  b = k % base;
            int c = k / base;
            if(b!= 0){
                builder.append(a1[c]);
                k = b;
                for(int m=c;m< n - 1 - count;m++){
                    a1[m] = a1[m+1] ;
                }
                base = base / (n-1-count);
                count++;
            }else{
            builder.append(a1[c-1]);
             for(int m= n - 1 - count;m > -1;m--){
                 if(m != c-1){
                     builder.append(a1[m]);
                 }
                }
                  break;

            }


        }
        return builder.toString();


    }
}

public class Solution {
    public int Fibonacci(int n) {
        
        if(n == 0){
            return 0;
        }
        
        if(n == 1){
            return 1;
        }
        
        int i1 = 0;
        int i2 = 1;
    
        for(int i = 1;i < n; i++){
            int tmp = i1 + i2;
            i1 = i2;
            i2 = tmp;
        }
        return i2;
    }
}
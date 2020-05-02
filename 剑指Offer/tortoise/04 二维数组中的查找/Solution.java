public class Solution {
   public boolean Find(int target, int [][] array) {
        // 1 2 3 4
        // 3 4 5 6
        // 4 6 8 10
        // 9 11 13 15
        if(array == null || array.length == 0){
            return false;
        }

        int m = array.length;
        int n = array[0].length;
        
       
       int i = 0;
       int j = n - 1;
        while(i < m && j >= 0){
            if(array[i][j] == target){
                return true;
            }else if(array[i][j] < target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
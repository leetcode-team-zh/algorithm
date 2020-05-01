import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result  = new ArrayList<>();
        if(numRows == 0) return result;  
    
        result.add(Arrays.asList(1));

        for(int n=1;n<numRows;n++){
            List<Integer> curRow = new ArrayList<>();
            List<Integer> preRow = result.get(n - 1);

            curRow.add(1);
            for(int m =0;m<preRow.size()-1;m++){
                curRow.add(preRow.get(m) + preRow.get(m+1));
            }
            curRow.add(1);
            result.add(curRow);
        }
        return result;
    }
}

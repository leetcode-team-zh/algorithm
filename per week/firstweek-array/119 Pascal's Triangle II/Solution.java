import java.util.*;
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = Arrays.asList(1);
        List<Integer> cur;

        for(int n=0;n<rowIndex;n++){

            cur = new ArrayList<>(n+1);
            cur.add(1);
            for(int m=0;m<pre.size()-1;m++){
                cur.add(pre.get(m)+pre.get(m+1));
            }
            cur.add(1);

            pre=cur;
        }
        return pre;


    }
}

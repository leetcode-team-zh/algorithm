class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int maxLevelSize = triangle.size();
        if(maxLevelSize == 0){
            return 0;
        }

        int[] curLevel = new int[maxLevelSize];
        int[] preLevel = new int[maxLevelSize];
        preLevel[0] = triangle.get(0).get(0);

        for(int n = 1;n < triangle.size(); n++){

            List<Integer> curLevelValue = triangle.get(n);
            for(int m=0;m < n + 1;m++){
                if(m == 0){
                    curLevel[m] = curLevelValue.get(m)+preLevel[m];
                }
                else if(m == n){
                    curLevel[m] = curLevelValue.get(m) +  preLevel[m - 1];
                }else{
                    curLevel[m] = curLevelValue.get(m) +  Math.min(preLevel[m-1],preLevel[m]);
                }
            }
            int[] tmp = preLevel;
            preLevel = curLevel;
            curLevel = tmp;
        }
        int minPath = Integer.MAX_VALUE;
        for(int ele : preLevel){
            if(ele < minPath){
                minPath = ele;
            }
        }
        return minPath;

    }
}

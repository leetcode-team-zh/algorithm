class Solution {
     public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);

        for(int i = 1; i < numRows ; i ++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < result.get(i -1).size(); j ++){
                temp.add(result.get(i - 1).get(j) + result.get(i - 1).get(j -1));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }
}

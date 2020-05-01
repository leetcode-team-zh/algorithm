public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, 0, nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, int start, int[] nums){
        if(start == nums.length){
            List<Integer> tmpList = new ArrayList<>();
            for(int i:nums)
                tmpList.add(i);
            list.add(new ArrayList<>(tmpList));
        } else{
            for(int i = start; i < nums.length; i++){
                swap(start,i,nums);
                backtrack(list, start+1, nums);
                swap(i,start,nums);
            }
        }
    }
    private void swap(int i,int j, int[] nums){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

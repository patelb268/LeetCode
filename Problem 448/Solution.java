class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i]) - 1] < 0) continue;
            nums[Math.abs(nums[i]) - 1] *= -1;
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}

/** TC :L O(N) SC : O(1)*/

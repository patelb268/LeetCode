class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i], i);
            
        }
        return new int[]{};
    }
}

/** 
  * Time Complexity : O(N)
  * Space Complexity : O(N)
  */

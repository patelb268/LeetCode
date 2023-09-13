class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int r_sum = 0;
        int max_length = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0) r_sum+=-1;
            if(nums[i] == 1) r_sum+=1;
            
            if(map.containsKey(r_sum)){
                max_length = Math.max(max_length, i - map.get(r_sum));
                continue;
            }
            map.put(r_sum,i);
        }
        return max_length;
    }
}

/**
  * Time Complexity : O(N)
  * Space Complexity : O (N)
  */

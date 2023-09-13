class Solution {
    public int subarraySum(int[] nums, int k) {
        if(k == 0 && nums.length == 1) return 0;
        int n = nums.length;
        int cumulative_sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int result = 0;
        for(int i = 0; i < n; i++){
            cumulative_sum += nums[i];
            int diff = cumulative_sum - k;
            if(map.containsKey(diff)){
                result+=map.get(diff);
            }
             map.put(cumulative_sum, map.getOrDefault(cumulative_sum,0) + 1);
        }
        return result;
    }
}

/** 
  * Time Complexity : O(N)
  * Space Complexity : O(N)
*/

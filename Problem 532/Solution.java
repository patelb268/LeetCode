class Solution {
    
    public int findPairs(int[] nums, int k) {
        HashSet<List<Integer>> set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            int com = nums[i] + k;
            if(map.containsKey(com)){
                int j = map.get(com);
                if(i == j) continue;
                List<Integer> li = new ArrayList<>();
                li.add(nums[i]);
                li.add(com);
                set.add(li);
            }
        }
        return set.size();
    }
}

/**
  * Time Complexity : O(N)
  * Space Complexity : O(N)
  */

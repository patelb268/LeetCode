class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        while(i < n - 2){
            if(i != 0 && nums[i] == nums[i - 1]){
                i++;
                continue;
            } 
            int target2sum = 0-nums[i];
            //perform 2 sum
            int j = i + 1;
            int k = n -1;
            while(j < k){
                int sum = nums[j] + nums[k];
                if(sum == target2sum){
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    result.add(temp);
                    k--;
                    j++;
                     while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                     while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                }else if(sum > target2sum){
                    k--;
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                }else{
                    j++;
                     while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                }
            }
            i++;
            
        }
        return result;
        
    }
}

/**
  * Time Complexity : O(N^2)
  * Space Complexity : O(1)
  */

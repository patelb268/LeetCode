class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        int count = 1;
        
        while(j < nums.length){
            if(nums[j] == nums[j - 1]){
                
                    count++;

            }
            else{
                count = 1;
                
            }
            
            if(count <= 2){
                nums[i] = nums[j];
                i++;
            }
            
            
            j++;
            
        }
        return i;
    }
}

/**
  * Time Complexity : O(N)
  * Space Complexity : O(1)
  */

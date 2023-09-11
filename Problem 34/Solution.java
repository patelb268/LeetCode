class Solution {
    public int[] searchRange(int[] nums, int target) {
       
        return new int [] { binary_search_left(nums,target),  binary_search_right(nums,target)};
        
    }

    public int binary_search_left(int [] nums,int target){
        int low = 0;
        int high = nums.length - 1;
        int first = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high= mid - 1;
            }
        }
        return first;
    }
    
    public int binary_search_right(int [] nums,int target){
        int low = 0;
        int high = nums.length - 1;
        int last = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high= mid - 1;
            }
        }
        return last;
    }
}

/**
  * Time Complexity : O(log N)
  * Space Complexity : O(1)
  */

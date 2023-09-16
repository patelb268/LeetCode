class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        int p2 = nums.length -1;
        
        while(p1 <= p2){
            if(nums[p1] == 0){
                swap(p0,p1,nums);
                p0++;
                p1++;
            }else if(nums[p1] == 1){
                p1++;
            }else{
                swap(p1,p2,nums);
                p2--;
            }
        }
    }
    
    public void swap(int a, int b, int[] nums){
    
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

/** 
  * Time Complexity : O(N)
  * Space Complexity : O(1)
  */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] lp = new int [nums.length];        
        
        //calculate left running product
        int lr_prod = 1;
        lp[0]=1;
        for(int i = 1; i<nums.length; i++){
            lr_prod *= nums[i-1];
            lp[i] = lr_prod;
        }
        
        //calculate right running Product
        int  rr_prod = 1;
        for(int i = nums.length - 2; i>=0; i--){
            rr_prod *= nums[i+1];
            lp[i] *= rr_prod;
        }
        return lp;
    }
}

/**
  * Time Complexity : O(N);
  * Space Complexity :O(1);
  */

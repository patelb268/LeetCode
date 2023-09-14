// Exaustive Solution
class Solution {
    public int rob(int[] nums) {
        return helper(nums,0,0);
    }
    
    public int helper(int[] nums, int index, int loot){
        //base
        if(index >= nums.length){
            return loot;
        }        
        //logic
        //choose
        int case1= helper(nums,index + 2, loot + nums[index]);
        //not choosing
        int case2= helper(nums,index+1,loot);
        
        return Math.max(case1,case2);
    }
}

/**
  * Time Complexity : O(2^N)
  * Spcae Complexity : O(N + M)
  */

//Dynamic Programming Top - Down

class Solution {
    int[] max_loot;
    public int rob(int[] nums) {
        max_loot = new int[nums.length];
        Arrays.fill(max_loot,-1);
        return helper(nums,0,0);
    }
    
    public int helper(int[] nums, int index, int loot){
        //base
        if(index >= nums.length){
            return ;
        }    
        if(max_loot[index] != -1) return max_loot[index];
        
        
        //logic
        //choose
        int case1= helper(nums,index + 2, loot + nums[index]);
        //not choosing
        int case2= helper(nums,index+1,loot);
        
        max_loot[index] = Math.max(case1,case2);
        return max_loot[index];
    }
}

/**
  * Time Complexity : O(N)
  * Spcae Complexity : O(N + M)
  */


//Dynamic Programming Bottom - Up

class Solution {
    public int rob(int[] nums) {
        int [][] dp = new int [nums.length][2];
        dp[0][0] = nums[0];
        
        for(int i = 1; i < dp.length; i++){
            //choose
            dp[i][0]= dp[i-1][1] + nums[i];
            //not choose
            dp[i][1]= Math.max(dp[i-1][0],dp[i-1][1]);
        }
        
        return Math.max(dp[dp.length - 1][0],dp[dp.length -1][1]);
    }
}

/**
  * Time Complexity : O(N)
  * Spcae Complexity : O(N)
  */


//Dynamic Programming Bottom - Up ( Space Optimized)

class Solution {
    public int rob(int[] nums) {
        int skip = 0;
        int take = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = take;
            take = nums[i] + skip;
            skip = Math.max(skip,temp);
        }
        
        return Math.max(skip,take);
    }
}

/**
  * Time Complexity : O(N)
  * Spcae Complexity : O(1)
  */

/* Exhaust Approach*/
class Solution {

    public int coinChange(int[] coins, int amount) {
        return helper(coins,amount,0,0);
    }
    
    public int helper(int [] coins, int amount, int index,int total){
        //base
        if(amount == 0){
            return total;
        }
        if(amount < 0 || index == coins.length)
        {
            return -1;
        }     
        
        //logic
        //choose
        int case1 = helper(coins, amount - coins[index], index, total + 1);
        //not choose
        int case2 = helper(coins, amount, index + 1, total);
        
        if(case1 == -1){
            return case2;
        }
        if(case2 == -1){
            return case1;
        }
        
        return Math.min(case1, case2);
        
    }
}


/**
  * Time Complexity : O(2^N) Time Limit Execed
  * Space Complexity : O(M+N) M = choose , N = not Choose
  */

/* Dynamic Programming  Bottom - Up*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int [coins.length + 1][amount + 1];
        dp[0][0] = 0;
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount + 1;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j] , dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        
        int result = dp[dp.length - 1][dp[0].length - 1];
        if(result > amount)return -1;
        return result;
        
    }
}

/**
  * Time Complexity : O(M * N)
  * Space Complexity : O(M * N) 
  * M = number of coins   N = amount
  */

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[]dp = new int [amount + 1];
        for(int j = 1; j < dp.length; j++){
            dp[j] = amount + 1;
        }
        
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j < dp.length; j++){
                
                if(j < coins[i]){
                    continue;
                }
                else{
                    dp[j] = Math.min(dp[j] , dp[j - coins[i]] + 1);
                }
            }
        }
        
        int result = dp[dp.length - 1];
        if(result > amount)return -1;
        return result;
        
    }
}

/**
  * Time Complexity : O(M * N)
  * Space Complexity : O(N) 
  * M = number of coins   N = amount
  */

/*Dynamic Programming top-down*/
class Solution {
    int coin_used[];
    public int coinChange(int[] coins, int amount) {
        coin_used = new int[amount+1];
        return helper(coins,amount);
    }
    
    public int helper(int [] coins, int amount){
        //base
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(coin_used[amount] != 0) return coin_used[amount];
        
        //logic
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = helper(coins, amount - coin);
            if(res>=0 && res < min){
                min = 1 + res;
            }
        }
        coin_used[amount] = (min == Integer.MAX_VALUE)? -1 : min;
        return coin_used[amount];
        
        
    }
}

/**
  * Time Complexity : O(M * N)
  * Space Complexity : O(N) 
  * M = number of coins   N = amount
  */




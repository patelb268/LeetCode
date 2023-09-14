// Exaustive Approach
class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins,0,amount);
    }
    
    public int helper(int[] coins, int index, int amount){
        //base
        if(amount == 0) return 1;
        if(amount < 0 || index == coins.length) return 0;
        
        //logic
        int take = helper(coins,index, amount - coins[index]);
        int skip = helper(coins,index + 1, amount);
        
        return take + skip;
    }
}

/**
  Time Complexity : O(2^N)
  Space Complexity : O(N)
  */

// DP Top DOwn

class Solution {
    int[][] dp;

    public int change(int amount, int[] coins) {
        dp = new int[coins.length + 1][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(coins, coins.length, amount);
    }

    public int helper(int[] coins, int index, int amount) {
        if (amount == 0) return 1;
        if (amount < 0 || index <= 0) return 0;
        if (dp[index][amount] != -1) return dp[index][amount];

        int includeCoin = helper(coins, index, amount - coins[index - 1]);
        int excludeCoin = helper(coins, index - 1, amount);

        dp[index][amount] = includeCoin + excludeCoin;
        return dp[index][amount];
    }
}


/**
  Time Complexity : O(M * N)
  Space Complexity : O(M * N)
  */


//DP Bottom Up

class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int [coins.length + 1][amount + 1];
        
        dp[0][0] = 1;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length-1];
    }
}


/**
  Time Complexity : O(M * N)
  Space Complexity : O(M * N)
  */

//DP Bottom Up Space Optimized

class Solution {
    public int change(int amount, int[] coins) {
        int []dp = new int [amount + 1];
        
        dp[0] = 1;
        
       for(int i = 0; i < coins.length; i++){
        for(int j = 0; j < dp.length; j++){
            if(j < coins[i]){
                continue;
            }else{
                dp[j] += dp[j - coins[i]];
            }
        }
       }
        return dp[dp.length -1];
    }
}

/**
  Time Complexity : O(M * N)
  Space Complexity : O(N) N = amount
  */


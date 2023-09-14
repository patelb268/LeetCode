/* Exaustive Solution*/
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)return 0;
        int case1 = helper(costs,0,0,0);
        int case2 = helper(costs,0,1,0);
        int case3 = helper(costs,0,2,0);
        return Math.min(case1,Math.min(case2,case3));
    }
    private int helper(int costs[][], int row, int color, int costsofar){
        //base
        if(row == costs.length) return costsofar;
        //logic
        if(color == 0){
            return Math.min(helper(costs,row + 1,1,costsofar+costs[row][0]),
                            helper(costs,row + 1,2,costsofar+costs[row][0]));
        }
        if(color == 1){
            return Math.min(helper(costs,row + 1,0,costsofar+costs[row][1]),
                            helper(costs,row + 1,2,costsofar+costs[row][1]));
        }
        if(color == 2){
            return Math.min(helper(costs,row + 1,0,costsofar+costs[row][2]),
                            helper(costs,row + 1,1,costsofar+costs[row][2]));
        }
        return costsofar;
    }
}

/**
  * Time Complexity : O(2^N);
  * Space Complexity : O(N);
*/

//Dynamic Programming Top - Down
class Solution {
    int dp[][];
    public int minCost(int[][] costs) {
        dp = new int[costs.length][3];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        if(costs == null || costs.length == 0)return 0;
        int case1 = helper(costs,0,0);
        int case2 = helper(costs,0,1);
        int case3 = helper(costs,0,2);
        return Math.min(case1,Math.min(case2,case3));
    }
    private int helper(int costs[][], int row, int color){
        //base
        if(dp[row][color] > -1) return dp[row][color];
        
        if(row == costs.length - 1) return costs[row][color];
        
        int costsofar = costs[row][color];
        
        //logic
        if(color == 0){
           costsofar +=  Math.min(helper(costs,row + 1,1),
                            helper(costs,row + 1,2));
        }
        if(color == 1){
            costsofar += Math.min(helper(costs,row + 1,0),
                            helper(costs,row + 1,2));
        }
        if(color == 2){
            costsofar += Math.min(helper(costs,row + 1,0),
                            helper(costs,row + 1,1));
        }
        dp[row][color] = costsofar;
        return costsofar;
    }
}
/**
  * Time Complexity : O(M * N);
  * Space Complexity : O(M * N);
*/


// Dynamic Programing Bottom - Up
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        
        for(int i = n-2; i >=0 ; i-- ){
            costs[i][0] += Math.min(costs[i+1][1],costs[i+1][2]);
            
            costs[i][1] += Math.min(costs[i+1][0],costs[i+1][2]);
            
            costs[i][2] += Math.min(costs[i+1][0],costs[i+1][1]);            
        }
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}

/**
  * Time Complexity : O(M * N);
  * Space Complexity : O(M * N);
*/

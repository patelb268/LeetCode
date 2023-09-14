class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++){
            int result = helper(matrix,0,i,0);
            min = Math.min(min,result);
            
        }
        
        return min;
    }

    public int helper(int[][] matrix,int row,int col, int sum){
        //base
        if(row == matrix.length) return sum;        
        
        //logic
        if(col == 0) return Math.min(helper(matrix,row + 1,col,sum + matrix[row][col]),
                        helper(matrix,row + 1,col + 1,sum + matrix[row][col]));
        
        if(col == matrix[0].length - 1) return Math.min(helper(matrix,row + 1,col,sum + matrix[row][col]),
                        helper(matrix,row + 1,col - 1,sum + matrix[row][col]));
        
        return Math.min(helper(matrix,row + 1, col, sum + matrix[row][col]),
                        Math.min(helper(matrix,row + 1,col - 1,sum + matrix[row][col]),
                        helper(matrix,row + 1,col + 1,sum + matrix[row][col])));
    }
}

/**
  * Time Complexity : (N.3^N)
  * Space Complexity : O(N)
*/


// Dynamic Programming 
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int [][] dp = new int [matrix.length][matrix[0].length];
        dp[matrix.length - 1] = matrix[matrix.length - 1].clone();
        
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = 0; j < dp[0].length; j++){
                if(j == 0)
                    
                    dp[i][j] =matrix[i][j] +  Math.min(dp[i+1][j], dp[i+1][j+1]);
                
                else if( j == dp[0].length - 1)
                    
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j-1]);
                
                else
                    
                   dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], Math.min(dp[i + 1][j + 1],dp[i + 1][j - 1]));
                
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int num : dp[0]){
            result = Math.min(result,num);
        }
        return result;
    }
        
}
/**
  * Time Complexity : O(M * N)
  * Spcace Complexity : O(M * N)
  */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0; int left = 0;
        int btm = m - 1; int right = n - 1;
        
        List<Integer> result = new ArrayList<>(); 
        
        while(top <= btm && left <= right){
            for(int k = left; k <= right; k++){
                result.add(matrix[top][k]);
            }
            top++;
            
            for(int k = top; k <= btm; k++){
                result.add(matrix[k][right]);
            }
            right--;
            
            if(top <= btm){
                for(int k = right; k >= left; k--){
                    result.add(matrix[btm][k]);
                }
                 btm--;
            }
            
           
            if(left <= right){
                 for(int k = btm; k >= top; k--){
                    result.add(matrix[k][left]);
                }
                left++;
            }
           
        }
        return result;
        
    }
}

/** TC : O(N) SC: O(N) */

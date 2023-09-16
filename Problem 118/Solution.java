class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> result = new ArrayList<>();

        
        for(int i = 0; i < numRows; i++){
            List<Integer> li = new ArrayList<>();
            for(int j = 0; j < i+1; j++){
                if(j == 0 || j == i) li.add(1);
                else{
                    int left = result.get( i - 1).get(j - 1);
                    int right = result.get(i - 1).get(j);
                    li.add(left + right);
                }
            }
            result.add(li);
        }
            
        return result;
    }
}

/**
  * Time Complexity : O(N^2)
  * Space Complexity : o(1)
  */

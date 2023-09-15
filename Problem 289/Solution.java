class Solution {
    int[][] dirs;
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j<board[0].length; j++){
                int live = helper(i,j,board);
                if(board[i][j] == 1 && (live > 3 || live < 2)){
                    board[i][j] = -1;
                }
                if(board[i][j] == 0 && live == 3)board[i][j] = 2;
            }
        }
        
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == 2) board[i][j] = 1;
                if(board[i][j] == -1)board[i][j] = 0;
            }
        }
    }
    
    public int helper(int row, int col,int[][] board){
        int live_count = 0;
        for(int[] dir : dirs){
            int r = row + dir[0];
            int c = col + dir[1];
            if(r >= 0 && r < m  && c >= 0 && c < n && 
               (board[r][c] == 1 || board[r][c] == -1)){
                live_count++;
            }
            
        }
        return live_count;
    }
}

/** TC : O(M * N) SC : O(M * N) if not inplace.  if in-place SC: O(1)*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return helper(root) != -1;
        
    }
    
    public int helper(TreeNode root){
        //base
        if(root == null){
            return 0;
        }
        
        
        //recursion
        
        int left_height = helper(root.left);
        
        int right_height = helper(root.right);
        
        if(left_height == -1 ||right_height == -1 || Math.abs(left_height - right_height) > 1){
            return -1;
        }
        
        return Math.max(left_height,right_height) + 1;
        
        
    }
}

//Time : O(N)
//Space : O(H) where H could be N = number of nodes if tree is unbalanced

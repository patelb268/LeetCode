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
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null) return result;
        target = targetSum;
        helper(root,0,new ArrayList<>());
        return result;        
    }
    
    public void helper(TreeNode root, int sum, List<Integer>list){
        //base
        if(root == null) return;
        
        
        //logic
        list.add(root.val);
        sum += root.val;
        helper(root.left, sum ,new ArrayList<>(list));
        
        if(sum == target && root.left == null && root.right == null){
            result.add(list);
        }
        
        helper(root.right,sum ,new ArrayList<>(list));
        
    }
}

/**
  * Time Complexity : O(N * N)
  * Space Complexity : O(N * N)
  */


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
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null) return result;
        target = targetSum;
        helper(root,0,new ArrayList<>());
        return result;        
    }
    
    public void helper(TreeNode root, int sum, List<Integer>list){
        //base
        if(root == null) return;
        
        
        //logic
        //Action 
        list.add(root.val);
        sum += root.val;
        if(sum == target && root.left == null && root.right == null){
            result.add(new ArrayList<>(list));
        }
        
        //recursion
        helper(root.left, sum , list);
        
        helper(root.right,sum ,list);
        
        
        //backtrack
        list.remove(list.size() - 1);
        
       
        
        
    }
}
/**
  * Time Complexity : O(N)
  * Space Complexity : O(N)
  */


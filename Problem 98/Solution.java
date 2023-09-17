/* Recursive */
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
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        prev = null;
        inorder(root);
        return flag;
    }
    
    public void inorder(TreeNode root){
        //base
        if(root == null) return;
        
        
        //logic
        inorder(root.left);
        //st.pop() //[10,20,25]
        //inorder
        if(prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root; //[10,20,25]
        
        inorder(root.right);
        //st.pop()
        //[10,25,20]
    }
}

/**
  * Time Complexity : O(N)
  * Space Complexity :O(N)
  */

// Iterative Solution
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
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
}


/**
  * Time Complexity : O(N)
  * Space Complexity :O(N)
  */


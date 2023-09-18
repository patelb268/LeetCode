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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return true;
        if(left != null && right == null || left == null && right != null) return false;
        if(left.val != right.val)return false;
        
        //logic
        
        if(helper(left.left,right.right) && helper(left.right, right.left)) return true;
        return false;
    }
}

/**
  * Time Complexity : O(N)
  * Space Complexity : O(N)
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        Stack<TreeNode> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while(!st.isEmpty()){
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            if(left == null && right == null)continue;
            if(left == null && right !=null)return false;
            if(left != null && right ==null)return false;
            if(left.val != right.val)return false;
            st.push(left.left);
            st.push(right.right);
            st.push(left.right);
            st.push(right.left);

        }
        return true; 
    }
}//iterative solution
/**
  * Time Complexity : O(N)
  * Space Complexity : O(N)
  */

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
    int result;
    public int sumNumbers(TreeNode root) {
        result = 0;
        helper(root,0);
        return result;
    }
    
    public void helper(TreeNode root,int num){
        //base
        if(root.left == null && root.right == null){
            result += num * 10 + root.val;
        }
        //logic
        if(root.left != null) helper(root.left,num*10 + root.val);
        if(root.right != null )helper(root.right,num*10 + root.val);
    }
}

/**
  * Time Complexity : O(N)
  * Space Complexity : O(H) H = height of tree
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
    class Pair{
        TreeNode node;
        int num;
        public Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
        
        public TreeNode getNode(){
            return this.node;
        }
        
        public int getNum(){
            return this.num;
        }
    }
    
    public int sumNumbers(TreeNode root) {
        Stack<Pair> st = new Stack<>();
        int result = 0;
        int currNum = 0;
        while(root != null || !st.isEmpty()){
            while(root != null){
                currNum = currNum * 10 + root.val;
                Pair pair = new Pair(root,currNum);
                
                st.push(pair);
                root = root.left;
            }
            Pair currPair = st.pop();
            currNum = currPair.getNum();
            root = currPair.getNode();
            if(root.left == null && root.right == null){
                result += currNum;
            }
            root = root.right;
        }
        return result;
    }
}
/**
  * Time Complexity : O(N)
  * Space Complexity : O(H) H = height of tree
  */


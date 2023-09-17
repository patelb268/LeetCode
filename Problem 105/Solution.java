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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;
        for(int i = 0; i < inorder.length; i++){
            if(rootVal == inorder[i]){
                rootIdx = i;
                break;
            }
        }
        
        int[] inLeft = Arrays.copyOfRange(inorder,0,rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder,rootIdx + 1, inorder.length);
        int[] preLeft= Arrays.copyOfRange(preorder,1,rootIdx + 1);
        int[] preRight = Arrays.copyOfRange(preorder,rootIdx + 1, preorder.length);
        
        
        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);
        
        return root;
        
    }
}


/**
  * Time Complexity : O(N * N)
  * Space Complexity : O(N * N)
  */


//Optimization using HashMap


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
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        idx = 0;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length - 1);
        
    }
    
    public TreeNode helper(int [] preorder, int start, int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx]);        
        idx++;
        
        int rootIdx = map.get(root.val);
        root.left = helper(preorder,start,rootIdx - 1);
        root.right = helper(preorder,rootIdx + 1, end);
        return root;
        
        
    }
}

/**
  * Time Complexity : O(N)
  * Space Complexity : O(N)
  */

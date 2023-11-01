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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = que.size();
            for(int i = size; i > 0; i--){
                TreeNode curr = que.poll();
                list.add(curr.val);
                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
            }
            result.add(list);
        }
        return result;
        
    }
}
// Time : O(N)
//Space : O(N) Size of Queue



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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if(root == null) return result;
        helper(root,0,result);
        return result;
    }
    
    public void helper(TreeNode root, int level, List<List<Integer>> result){
        //base
        if(root == null){
            return;
        }
        
        //recursion
        if(result.size() == level){
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        
        result.get(level).add(root.val);
        
        helper(root.left, level + 1,result);
        helper(root.right, level + 1,result);
        
        return;
    }
}

//Time: O(N)
//Space: O(N)

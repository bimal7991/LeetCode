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
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        helper(root);
        int t=first.val;
        first.val=second.val;
        second.val=t;
    }
    public void helper(TreeNode root){
        if(root==null)
            return;
        helper(root.left);
        if(prev!=null)
        {
            if(prev.val>root.val && first==null)
                first=prev;
            if(prev.val>root.val && first!=null)
                second=root;
        }
          prev=root;
        helper(root.right);
    }
}
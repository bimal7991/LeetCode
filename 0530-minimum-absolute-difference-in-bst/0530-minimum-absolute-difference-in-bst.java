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
    Integer prev;
    Integer max=999999;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return max;
    }
    void helper(TreeNode root){
        if(root==null)
            return;
        helper(root.left);
        //System.out.println(root.val+" "+prev);
        if(prev==null){
            prev=root.val;
        }
        else
        {
            max=Math.min(max,Math.abs(prev-root.val));
            prev=root.val;
        }
        helper(root.right);
    }
}
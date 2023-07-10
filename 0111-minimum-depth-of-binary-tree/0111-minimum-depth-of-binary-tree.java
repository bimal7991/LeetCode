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
    int max=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        getDepth(root,1);
        return max;
    }
    public void getDepth(TreeNode root,int height){
        if(root.left==null && root.right==null)
        {
            max=Math.min(max,height);
            return;
        }
        if(root.left!=null)
        getDepth(root.left,height+1);
        if(root.right!=null)
        getDepth(root.right,height+1);
    }
}
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode p=new TreeNode(val);
            p.left=root;
            return p;
        }
        TreeNode q=root;
        helper(root,val,depth-2);
        return q;
           
    }
    void helper(TreeNode root,int val,int depth){
        if(root==null)
            return;
        if(depth==0){
            TreeNode p=root.left;
            root.left=new TreeNode(val);
            root.left.left=p;
            TreeNode q=root.right;
            root.right=new TreeNode(val);
            root.right.right=q;
            return;
        }
        helper(root.left,val,depth-1);
        helper(root.right,val,depth-1);
    }
}
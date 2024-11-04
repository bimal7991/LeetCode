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
    int max=0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return max;
    }
    public TreeInfo helper(TreeNode root){
        if(root==null)
            return new TreeInfo(Integer.MAX_VALUE,Integer.MIN_VALUE,true,0);
        TreeInfo left=helper(root.left);
        TreeInfo right=helper(root.right);
        boolean bst=left!=null && right!=null && left.isBst && right.isBst && root.val>left.max && root.val<right.min;
        if(bst){
            int s=left.sum+right.sum+root.val;
            max=Math.max(max,s);
            return new TreeInfo(Math.min(left.min,root.val), Math.max(root.val,right.max),bst,s);
        }else
            return null;
        
    }
}
class TreeInfo{
    int min,max;
    boolean isBst;
    int sum=0;
    TreeInfo(int min,int max,boolean isBst,int sum){
        this.min=min;
        this.max=max;
        this.isBst=isBst;
        this.sum=sum;
    }
}
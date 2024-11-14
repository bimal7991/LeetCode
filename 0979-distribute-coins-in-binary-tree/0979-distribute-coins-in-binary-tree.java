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
    int ans=0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return ans;
    }
    public int[] helper(TreeNode root){
        if(root==null)
            return new int[]{0,0};
        int left[]=helper(root.left);
        int right[]=helper(root.right);
        int size=left[0]+right[0]+1;  //1 
        int coin=left[1]+right[1]+root.val;
        ans=ans+Math.abs(size-coin);
        return new int[]{size,coin};
    }
}
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
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MAX_VALUE);
        
    }
    public TreeNode helper(int []preorder,int ub){
        if(index==preorder.length || preorder[index]>ub)
            return null;
        TreeNode root=new TreeNode(preorder[index++]);
        root.left=helper(preorder,root.val);
        root.right=helper(preorder,ub);
        return root;
    }
}
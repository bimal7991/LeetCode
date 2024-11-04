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
class TreeInfo{
    boolean isBST;
    int min,max,sum,totalSum,size;
    TreeInfo(boolean isBst,int min,int max,int sum){
        this.isBST=isBst;
        this.min=min;
        this.max=max;
        this.sum=sum;
    }
}
class Solution {
   
    public int maxSumBST(TreeNode root) {
        int ans[]=new int[1];
        helper(root,ans);
        return ans[0];
    }
    public TreeInfo helper(TreeNode tree,int ans[]){
        if(tree==null)
            return new TreeInfo(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        
        TreeInfo left=helper(tree.left,ans);
        TreeInfo right=helper(tree.right,ans);
        boolean isBST=left!=null && right!=null && left.isBST && right.isBST && tree.val>left.max && tree.val<right.min;
        
        if(isBST){
            int sum=left.sum+right.sum+tree.val;
           ans[0]=Math.max(ans[0],sum);
            return new TreeInfo(isBST,Math.min(tree.val,left.min),Math.max(tree.val,right.max),sum);       
        }
        else
            return null;
        

    }
    
}
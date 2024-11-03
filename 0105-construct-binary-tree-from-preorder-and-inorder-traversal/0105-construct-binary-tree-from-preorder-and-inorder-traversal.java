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
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        TreeNode root=helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
        return root;
        
    }
    TreeNode helper(int preorder[],int pf,int pl,int inorder[],int inf,int inl,HashMap<Integer,Integer> hm){
        if(pf>pl || inf>inl)
            return null;
        int val=preorder[pf];
        TreeNode root=new TreeNode(val);
        int inIndex=hm.get(val);
        int numLeft=inIndex-inf;
        root.left=helper(preorder,pf+1,pf+numLeft,inorder,inf,inIndex-1,hm);
        root.right=helper(preorder,pf+numLeft+1,pl,inorder,inIndex+1,inl,hm);
        return root;
    }
}
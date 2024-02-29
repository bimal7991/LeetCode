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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int s=q.size();
            int curr=(level%2==0)?-1:Integer.MAX_VALUE;
            for(int i=0;i<s;i++){
                TreeNode p=q.poll();
                if(level%2==0 && (p.val%2!=1 || p.val<=curr ))
                    return false;
                if(level%2==1 && (p.val%2!=0 || p.val>=curr))
                    return false;
                curr=p.val;
                if(p.left!=null)
                    q.add(p.left);
                if(p.right!=null)
                    q.add(p.right);
            }
            level++;
        }
        return true;
    }
}
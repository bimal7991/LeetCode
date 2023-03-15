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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
            return true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int k=0;
        while(q.peek()!=null){
            TreeNode temp=q.poll();
            q.add(temp.left);
            q.add(temp.right);
        }
        while(!q.isEmpty() && q.peek()==null)
            q.poll();
        
        return q.isEmpty();
    }
}
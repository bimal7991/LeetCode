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
    public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int s=q.size();
                boolean xP=false;
                boolean yP=false;
                for(int i=0;i<s;i++){
                    TreeNode temp=q.poll();
                    if(temp.left!=null && temp.right!=null){
                        if(temp.left.val==x && temp.right.val==y)
                            return false;
                        if(temp.left.val==y && temp.right.val==x)
                            return false;
                    }
                    if(temp.left!=null){
                        if(temp.left.val==x)
                            xP=true;
                         if(temp.left.val==y)
                            yP=true;
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        if(temp.right.val==x)
                            xP=true;
                         if(temp.right.val==y)
                            yP=true;
                        q.add(temp.right);
                    }
                }
                if(xP && yP)
                    return true;
            }
        return false;
    }
}
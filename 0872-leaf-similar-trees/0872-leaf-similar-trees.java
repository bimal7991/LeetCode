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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        s1.add(root1);
        s2.add(root2);
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(s1.isEmpty() || s2.isEmpty())
                return false;
            root1=s1.pop();
            while(root1!=null && !checkLeaf(root1)){
                if(root1.right!=null)
                    s1.push(root1.right);
                if(root1.left!=null){
                    s1.push(root1.left);
                }
                root1=s1.pop();
            }
            root2=s2.pop();
            while(root2!=null && !checkLeaf(root2)){
                if(root2.right!=null)
                    s2.push(root2.right);
                if(root2.left!=null){
                    s2.push(root2.left);
                }
                root2=s2.pop();
            }
            
            if(root1==null && root2!=null)
                return false;
            else if(root1!=null && root2==null)
                return false;
            else if(root1!=null && root2!=null)
            {
                if(root1.val!=root2.val)
                    return false;
            }
        }
        return true;
    }
    boolean checkLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }
}
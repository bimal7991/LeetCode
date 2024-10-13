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
    public void flatten(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        if(root==null)
            return;
        st.push(root);
        TreeNode prev=null;
        while(!st.isEmpty()){
            TreeNode temp=st.pop();
            if(temp.right!=null)
                st.push(temp.right);
            if(temp.left!=null)
                st.push(temp.left);
            if(prev!=null){
            prev.right=temp;
            prev.left=null;
            }
            prev=temp;
            
        }
    }
}
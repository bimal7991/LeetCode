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
    public List<Integer> postorderTraversal(TreeNode root) {
          Stack<TreeNode> st=new Stack<TreeNode>();
        List<Integer> arr=new LinkedList<Integer>();
        if(root==null)
            return arr;
        st.add(root);
        while(!st.isEmpty()){
            TreeNode temp=st.pop();
            arr.addFirst(temp.val);
            if(temp.left!=null)
            st.add(temp.left);
            if(temp.right!=null)
              st.add(temp.right);  
            
        }
        
        return arr;
    }
}
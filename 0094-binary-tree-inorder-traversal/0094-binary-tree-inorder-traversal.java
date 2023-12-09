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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> st=new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            if(root.left!=null){
                st.push(root.left);
                root=root.left;
            }
           else{
               if(st.isEmpty())
                   break;
            TreeNode temp=st.pop();
            list.add(temp.val);
             if(temp.right!=null){
                st.push(temp.right);
                root=temp.right;
             } 
           }   
            
        }
        return list;
        
    }
    void helper(TreeNode root,List<Integer> list){
        if(root==null)
            return ;
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }
}
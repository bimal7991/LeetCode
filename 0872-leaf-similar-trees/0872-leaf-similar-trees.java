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
        
        ArrayList<Integer> li1=getSequence(root1);
         ArrayList<Integer> li2=getSequence(root2);
         return li1.equals(li2);
               
    }
    ArrayList getSequence(TreeNode root){
        Stack<TreeNode> st=new Stack<>();
        ArrayList<Integer> li=new ArrayList<>();
        if(root==null)
        return li;
        st.push(root);
        while(!st.isEmpty()){
            int s=st.size();
            for(int i=0;i<s;i++){
                TreeNode temp=st.pop();
                if(temp.left==null && temp.right==null){
                      li.add(temp.val);
                }
                if(temp.left!=null)
                   st.push(temp.left);
                 if(temp.right!=null)
                   st.push(temp.right);    
            }
        }
        return li;
    }
}
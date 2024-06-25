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
    public TreeNode bstToGst(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        inorder(list,root);
        int sum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=list.size()-1;i>=0;i--){
            sum=sum+list.get(i);
            hm.put(list.get(i),sum);
        }
        inorder(hm,root);
        return root;
        
        
    }
     public void inorder(HashMap<Integer,Integer> hm, TreeNode root){
        if(root==null)
            return;
        inorder(hm,root.left);
         root.val=hm.get(root.val);
        inorder(hm,root.right);
    }
    public void inorder(ArrayList<Integer> list, TreeNode root){
        if(root==null)
            return;
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
    }
    
}
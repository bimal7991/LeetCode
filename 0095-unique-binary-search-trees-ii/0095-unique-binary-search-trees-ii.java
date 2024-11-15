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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int s,int end){
        //base
        List<TreeNode> res=new ArrayList<>();
        if(s>end){
            res.add(null);
            return res;
        }
        
        for(int i=s;i<=end;i++){
            List<TreeNode> left=generateTrees(s,i-1);
            List<TreeNode> right=generateTrees(i+1,end);
            
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    
                    res.add(root);
                }
            }
            
        }
        return res;
    }
}
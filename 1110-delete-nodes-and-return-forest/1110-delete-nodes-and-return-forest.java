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
    HashSet<Integer> set = new HashSet<>();
    List<TreeNode> list = new ArrayList<>();
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int val: to_delete){
            set.add(val);
        }
        helper(root);
        if(!set.contains(root.val)){
            list.add(root);
        }
        return list;
    }
    
    public TreeNode helper(TreeNode node){
        if(node == null)
            return null;
        
        node.left = helper(node.left);
        node.right = helper(node.right);
        
        if(set.contains(node.val)){
            if(node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
            return null;
        }
        return node;
    }
}
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int s=queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<s;i++){
                TreeNode curr=queue.poll();
                max=Math.max(curr.val,max);
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
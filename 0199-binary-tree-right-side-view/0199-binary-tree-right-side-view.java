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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        
        List<Integer> ans=new ArrayList<>();
        if(root==null)
            return ans;
        queue.add(root);
        while(!queue.isEmpty()){
            int s=queue.size();
            TreeNode first=null;
            for(int i=0;i<s;i++){
                TreeNode temp=queue.poll();
                if(first==null)
                    first=temp;
                if(temp.right!=null)
                    queue.add(temp.right);
                if(temp.left!=null)
                    queue.add(temp.left);
            }
            ans.add(first.val);
        }
        return ans;
    }
}
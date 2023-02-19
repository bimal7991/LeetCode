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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
            return list;
        q.add(root);
        int count=0;
        while(!q.isEmpty()){
            count++;
            int s=q.size();
            List<Integer> sub=new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode temp=q.poll();
                sub.add(temp.val);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            if(count%2==0){
                Collections.reverse(sub);
            }
            list.add(sub);
        }
        return list;
    }
}
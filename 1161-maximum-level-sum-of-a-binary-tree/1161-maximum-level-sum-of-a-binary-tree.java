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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level=0;
        long max=Long.MIN_VALUE;
        int ans=1;
        while(!q.isEmpty()){
            int s=q.size();
            level++;
            long sum=0;
            for(int i=0;i<s;i++){
                TreeNode temp=q.poll();
                sum=sum+temp.val;
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
                
            }
            if(sum>max){
                max=sum;
                ans=level;
            }
             
        }
        return ans;
    }
}
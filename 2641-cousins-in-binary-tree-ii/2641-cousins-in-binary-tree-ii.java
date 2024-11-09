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
   public TreeNode replaceValueInTree(TreeNode root) {
      Queue<TreeNode> queue=new LinkedList<>();
       HashMap<Integer,Integer> hm=new HashMap<>();
      queue.add(root);
      root.val=0;
       hm.put(0,root.val);
       int level=1;
       while(!queue.isEmpty()){
           int s=queue.size();
          int levelSum=0;
           for(int i=0;i<s;i++){
               TreeNode temp=queue.poll();
                int sum=0;
                if(temp.left!=null){
                    sum=sum+temp.left.val;
                    queue.add(temp.left);
                }
               if(temp.right!=null){
                   sum+=temp.right.val;
                   queue.add(temp.right);
               }
                if(temp.left!=null){
                    temp.left.val=sum;
                }
                if(temp.right!=null){
                   temp.right.val=sum;
               }
               levelSum+=sum;
           }
           hm.put(level,levelSum);
           level++;
       }
       // return root;
      queue.add(root);
       root.val=0;
       level=0;
       while(!queue.isEmpty()){
           int s=queue.size();
           int lsum=hm.get(level);
           for(int i=0;i<s;i++){
               TreeNode temp=queue.poll();
               temp.val=lsum-temp.val;
                int sum=0;
                if(temp.left!=null){
                    queue.add(temp.left);
                }
               if(temp.right!=null){
                   queue.add(temp.right);
               }

           }
           level++;
       }
       return root;
   }
}
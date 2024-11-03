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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue=new LinkedList<>();
        int max=0;
        queue.add(new Node(root,0));
        while(!queue.isEmpty()){
            int s=queue.size();
            int low=0,high=0;
            for(int i=0;i<s;i++){
                Node tree=queue.poll();
                if(i==0)
                    low=tree.w;
                if(i==s-1)
                    high=tree.w;
                if(tree.node.left!=null)
                    queue.add(new Node(tree.node.left,2*tree.w+1));
                if(tree.node.right!=null)
                    queue.add(new Node(tree.node.right,2*tree.w+2));
            }
            max=Math.max(max,high-low+1);
        }
        return max;
        
    }
}
class Node{
    TreeNode node;
    int w;
    Node(TreeNode n,int i){
        node=n;
        w=i;
    }
}
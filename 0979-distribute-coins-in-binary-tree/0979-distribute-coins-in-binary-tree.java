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
   private int steps = 0; 

public int distributeCoins(TreeNode root) {
    postorder(root);
    return steps;
}

// return coins of this level
private int postorder(TreeNode node) {
    if(node == null) return 0;
    
    // coin from children -- post-order traversal
    int coin = postorder(node.left) + postorder(node.right);
	
    // current node coin
    if(node.val == 0) coin += -1; // current node need one coin
    else coin += node.val - 1; // keep one coin for current node
    
    steps += Math.abs(coin); // each coin move up to parent node need 1 step
    return coin; 
}
}
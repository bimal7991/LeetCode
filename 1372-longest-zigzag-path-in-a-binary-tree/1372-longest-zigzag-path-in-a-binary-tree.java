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
    static int max = 0;
   public static int longestZigZag(TreeNode root) {
        if (root == null) return -1;
        max = 0;
        helper(root.right, 1, true);// go right
        helper(root.left, 1, false);// go left
        return max;
    }

    private static void helper(TreeNode root, int step, boolean isRight) {
        if (root == null) return;
        max = Math.max(max, step);
        if (isRight) {
            helper(root.left, step + 1, false);
            helper(root.right, 1, true);
        } else 
        {
            helper(root.right, step + 1, true);
            helper(root.left, 1, false);
        }
    }
}
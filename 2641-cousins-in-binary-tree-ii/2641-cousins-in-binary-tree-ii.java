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
    Map<Integer, Integer> m = new HashMap<>();
    dfs(root, 0, m);
    return dfs1(root, 0, new TreeNode(0), m);
}
private void dfs(TreeNode r, int l, Map<Integer, Integer> m) {
    if (r == null) return;
    m.put(l, m.getOrDefault(l, 0) + r.val);
    dfs(r.left, l + 1, m);
    dfs(r.right, l + 1, m);
}
private TreeNode dfs1(TreeNode r, int l, TreeNode curr, Map<Integer, Integer> m) {
    int sum_of_cousins = m.getOrDefault(l + 1, 0) - ((r.left != null) ? r.left.val : 0) - ((r.right != null) ? r.right.val : 0);
    if (r.left != null) {
        curr.left = new TreeNode(sum_of_cousins);
        dfs1(r.left, l + 1, curr.left, m);
    }
    if (r.right != null) {
        curr.right = new TreeNode(sum_of_cousins);
        dfs1(r.right, l + 1, curr.right, m);
    }
    return curr;
}
}
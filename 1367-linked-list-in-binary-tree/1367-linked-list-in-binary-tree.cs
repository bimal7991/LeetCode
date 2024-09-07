/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public bool IsSubPath(ListNode head, TreeNode root) {
        if(root==null)
            return false;
        if(root.val==head.val){
            if(Helper(head,root))
                return true;
        }
        bool left=IsSubPath(head,root.left);
        bool right=IsSubPath(head,root.right);
        return left || right;
    }
    public bool Helper(ListNode head,TreeNode root){
        if(head==null)
            return true;
        if(root==null)
            return false;
        if(head.val!=root.val)
            return false;
        bool left=Helper(head.next,root.left);
        bool right=Helper(head.next,root.right);
        return left || right;
    }
}

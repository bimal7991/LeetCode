/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        if(head==null)
            return true;
        if(root==null)
            return false;
        if(root.val==head.val){
            if(helper(head,root))
                return true;
        }
        boolean left=isSubPath(head,root.left);
        boolean right=isSubPath(head,root.right);
        return left || right;
//         Queue<TreeNode> q=new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int s=q.size();
//             for(int i=0;i<s;i++){
//             TreeNode p=q.poll();
//             if(p.val==head.val && helper(head,p))
//                 return true;
//              if(p.left!=null)
//                  q.add(p.left);
//              if(p.right!=null)
//                  q.add(p.right);
//             }
        
//         }
//         return false;
    }
    public boolean helper(ListNode head,TreeNode root){
        if(head==null)
            return true;
        if(root==null)
            return false;
       
        if(head.val!=root.val)
            return false;
        boolean left=helper(head.next,root.left);
        boolean right=helper(head.next,root.right);
        return left || right;
    }
}
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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode p=head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        slow.next=reverseList(slow.next);
        
        slow=slow.next;
        while(slow!=null){
            if(slow.val!=head.val)
                return false;
            slow=slow.next;
            head=head.next;
        }
        
        return true;
    }
    public ListNode  reverseList(ListNode node){
        
        ListNode next=null;
        ListNode prev=null;
        
        while(node!=null){
             next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }
}
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
    public ListNode doubleIt(ListNode head) {
        return doubleLinkedListNumber(head);
    }
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
        public  ListNode doubleLinkedListNumber(ListNode head) {
        head = reverseLinkedList(head);
        
        ListNode current = head;
        int carry = 0;
        ListNode temp=current;
        while (current != null) {
            temp=current;
            int sum = current.val * 2 + carry;
            current.val = sum % 10;
            carry = sum / 10;
            current = current.next;
        }
        
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            temp.next = newHead;
            
        }

        return reverseLinkedList(head);
    }

}

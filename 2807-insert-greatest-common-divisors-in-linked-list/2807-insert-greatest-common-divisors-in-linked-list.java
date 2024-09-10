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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp=head;
        while(head.next!=null){
            ListNode first=head;
            ListNode second=head.next;
            int g=gcd(first.val,second.val);
            ListNode mid=new ListNode(g);
            first.next=mid;
            mid.next=second;
            head=second;
            
        }
        return temp;
    }
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

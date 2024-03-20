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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head=list1;
        int count=1;
        ListNode first=list1;
        while(count!=b+1){
            if(count==a)
                first=head;
            count++;
            head=head.next;
        }
        first.next=list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=head.next;
        return list1;
        
    }
}
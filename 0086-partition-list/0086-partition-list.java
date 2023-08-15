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
    public ListNode partition(ListNode head, int x) {
        ListNode first=head;
        ListNode part1=new ListNode();
        ListNode part2=new ListNode();
        ListNode ans2=part2;
        ListNode ans1=part1;
        while(first!=null){
            if(first.val<x){
                part1.next=first;
                part1=part1.next;
            }
            else{
                part2.next=first;
                part2=part2.next;
            }
            first=first.next;
        }
        part2.next=null;
        part1.next=ans2.next;
        return ans1.next;
        
    }
}
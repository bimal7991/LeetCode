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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp=new ListNode();
        ListNode p=temp;
        int sum=0;
        head=head.next;
        while(head!=null){
            if(sum+head.val==sum){
                ListNode c=new ListNode(sum);
                temp.next=c;
                temp=temp.next;
                sum=0;
            }
            sum=sum+head.val;
            head=head.next;
        }
        return p.next;
    }
}
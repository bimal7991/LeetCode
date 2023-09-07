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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start=head;
        ListNode prev=null;
        int count=1;
        while(start!=null){
            
            if(count==left)
                break;
            prev=start;
            start=start.next;
            count++;
        }
        
        ListNode end=start;
        while(end!=null && count!=right){
            end=end.next;
            count++;
        }
        count=left;
        end=end.next;
        
        while(start!=null && count!=right+1){
            ListNode curr=start.next;
            start.next=end;
            end=start;
            start=curr;
            count++;
        }
        if(prev!=null)
        prev.next=end;
        else{
            head=end;
        }
        return head;
        
    }
}
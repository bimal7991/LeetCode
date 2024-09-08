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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode start=head;
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        ListNode[] ans=new ListNode[k];
        int rem=count%k;
        int s=count/k;
        ListNode temp=start;
        count=0;
        int i=0;
        while(start!=null){
            count++;
            if(rem>0 && count==s+1){
             ans[i]=temp;
             temp=start.next;
             start.next=null; 
             start=temp;
                 i++;
                count=0;
                rem--;
            }
            else if(count==s && rem==0){
                 ans[i]=temp;
             temp=start.next;
             start.next=null; 
             start=temp;
                 i++;
                count=0;
            }
            else
            start=start.next;
            
            
        }
        return ans;
        
    }
}
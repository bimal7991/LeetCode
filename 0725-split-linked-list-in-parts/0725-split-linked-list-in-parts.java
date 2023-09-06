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
        ListNode list[]=new ListNode[k];
        ListNode start=head;
        int size=0;
        while(start!=null){
            size++;
            start=start.next;
        }
        int n=size/k;
        int rem=size%k;
        if(k>size)
        {
            n=1;
            rem=0;
        }
        
        ListNode node=head;
        ListNode prev=null;
        int j=0;
        while(node!=null){
            list[j]=node;
            for(int i=0;i<n;i++){
                prev=node;
                node=node.next;
            }
            if(rem!=0){
                for(int i=0;i<1;i++){
                    prev=node;
                    node=node.next;
                    rem--;
                }
            }
            prev.next=null;
            j++;
            
        }
        return list;
    }
}
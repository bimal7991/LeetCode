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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums)
            hs.add(i);
        ListNode prev=new ListNode();
        ListNode ans=prev;
        while(head!=null){
            if(hs.contains(head.val)){
                
            }
            else{
                prev.next=head;
                prev=prev.next;
            }
            head=head.next;
        }
        prev.next=null;
        
        return ans.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode ModifiedList(int[] nums, ListNode head) {
        HashSet<int> hs=new HashSet<int>(nums);
        ListNode prev=new ListNode();
        ListNode ans=prev;
        while(head!=null){
            if(!hs.Contains(head.val)){
                prev.next=head;
                prev=prev.next;
            }
            head=head.next;
        }
        prev.next=null;
        return ans.next;
    }
}
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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode empty=new ListNode();
        empty.next=head;
        HashMap<Integer,ListNode> hm=new HashMap<>();
        hm.put(0,empty);
        int sum=0;
        while(head!=null){
            sum=sum+head.val;
            if(hm.containsKey(sum)){
                ListNode node=hm.get(sum);
                ListNode cur=node;
                node=node.next;
                int p=sum;
                while(node!=head){
                    p=p+node.val;
                    hm.remove(p);
                    node=node.next;
                }
                cur.next=head.next;
            }
            else
            hm.put(sum,head);
            head=head.next;
        }
        return empty.next;
    }
}
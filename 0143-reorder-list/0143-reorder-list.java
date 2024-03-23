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
    public void reorderList(ListNode head) {
        Stack<ListNode> st=new Stack<>();
        ListNode start=head;
        ListNode temp=head;
        while(head!=null){
            st.add(head);
            head=head.next;
        }
        int n=st.size();
        while(temp!=null){
             if(st.size()==(n+1)/2)
            break;
            ListNode top=st.pop();
            st.peek().next=null;
            ListNode p=temp.next;
            temp.next=top;
            top.next=p;
            temp=p;
           
        }
       
        
    }
}
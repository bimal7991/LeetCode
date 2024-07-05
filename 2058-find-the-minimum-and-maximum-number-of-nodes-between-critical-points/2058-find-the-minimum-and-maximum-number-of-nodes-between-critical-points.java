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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int previousLocal=-1;
        int startLocal=-1;
        int min=Integer.MAX_VALUE;
        int prev=head.val;
        head=head.next;
        int index=1;
        while(head.next!=null){
            if(head.val>prev && head.val>head.next.val){
                if(startLocal==-1)
                    startLocal=index;
                if(previousLocal==-1)
                    previousLocal=index;
                else
                {
                    min=Math.min(index-previousLocal,min);
                    previousLocal=index;
                }
                
            }
            if(head.val<prev && head.val<head.next.val){
                if(startLocal==-1)
                    startLocal=index;
                if(previousLocal==-1)
                    previousLocal=index;
                else
                {
                    min=Math.min(index-previousLocal,min);
                    previousLocal=index;
                }
            }
            index++;
            prev=head.val;
            head=head.next;
        }
        if(startLocal==previousLocal)
            return new int[]{-1,-1};
        return new int[]{min,previousLocal-startLocal};
    }
}
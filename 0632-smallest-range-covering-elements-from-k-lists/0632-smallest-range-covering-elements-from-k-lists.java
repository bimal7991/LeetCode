class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int range=Integer.MAX_VALUE;
        int start=-1;
        int end=-1;
        for(int i=0;i<nums.size();i++){
            pq.add(new Element(nums.get(i).get(0),i,0));
            max=Math.max(nums.get(i).get(0),max);
        }
        while(pq.size()==nums.size()){
            Element curr=pq.poll();
            if(max-curr.val<range){
                start=curr.val;
                end=max;
                range=max-curr.val;
            }
            if(curr.index+1<nums.get(curr.row).size()){
                 curr.index=curr.index+1;
                 curr.val=nums.get(curr.row).get(curr.index);
                 pq.offer(curr);
                 max=Math.max(max,curr.val);
            }
        }
        return new int[]{start,end};
    }
        
  
}
class Element {
   int val;
   int row;
   int index;
   Element(int v,int r,int i){
       val=v;
       row=r;
       index=i;
   }
}

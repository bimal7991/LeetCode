class Solution {
    public int furthestBuilding(int[] h, int b, int l) {
        int i=0;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,c)->c-a);
        for(i=1;i<h.length;i++){
            int diff=h[i]-h[i-1];
            if(diff<=0)
                continue;
            if(b>=diff){
                pq.add(diff);
                b=b-diff;
            }
            else{
                if(l<=0)
                    break;
                int max=pq.isEmpty()?0:pq.peek();
                l--;
                if(max>diff)
                {
                    b=b+max;
                    if(!pq.isEmpty())
                    pq.poll();
                    b=b-diff;
                    pq.add(diff);
                }       
            }     
            
        }
        return i-1;
    }
}
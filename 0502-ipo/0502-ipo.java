class Solution {
    public int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {
        PriorityQueue<int[]> pq=new  PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<capital.length;i++){
            pq.add(new int[]{capital[i],profit[i]});
        }
         PriorityQueue<int[]> p=new  PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<k;i++){
            while(!pq.isEmpty() && pq.peek()[0]<=w){
                p.add(pq.poll());
            }
            if(p.isEmpty())
                break;
            w=w+p.poll()[1];
        }
        return w;
    }
}
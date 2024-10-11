class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
         int t=times[targetFriend][0];
         Arrays.sort(times,(a,b)->a[0]-b[0]);
         PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<times.length;i++)
            pq.add(i);
        PriorityQueue<int[]> sit=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<times.length;i++){
            int s=times[i][0],e=times[i][1];
            while(!sit.isEmpty() && sit.peek()[0]<=s){
                pq.offer(sit.poll()[1]);
            }
            
            if(s==t)
            {
               break;
            }
            sit.offer(new int[]{e,pq.poll()});
        }
        return pq.peek();


    }
}
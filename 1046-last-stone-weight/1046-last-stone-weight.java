class Solution {
    public int lastStoneWeight(int[] stones) {
           PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
            for(int i=0;i<stones.length;i++)
                pq.add(stones[i]);
        
        
           while(!pq.isEmpty()){
                 if(pq.size()==1)
                   return pq.peek();
                int a=pq.poll();
                int b=pq.poll();
               if(a!=b)
                   pq.add(a-b);
               
           }
         
          return 0;
          
          
    }
}  
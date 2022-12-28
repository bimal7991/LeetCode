class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:piles){
            pq.add(i);
        }
       // System.out.println(pq);
        while(k>0){
            int p=pq.poll();
            if(p%2==0)
                pq.add(p/2);
            else
                pq.add(p/2+1);
            k--;
        }
        int sum=0;
        while(!pq.isEmpty()){
            sum=sum+pq.poll();
        }
        return sum;
        
        
    }
}
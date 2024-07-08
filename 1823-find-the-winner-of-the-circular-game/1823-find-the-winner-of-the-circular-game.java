class Solution {
    public int findTheWinner(int n, int k) {
         Queue<Integer> q=new LinkedList<>();
          for(int i=1;i<=n;i++)
                   q.add(i);
        
        while(q.size()!=1){
            int count=0;
            while(count!=k-1){
                q.add(q.poll());
                count++;
            }
            q.poll();
        }
        return q.poll();
    }
}
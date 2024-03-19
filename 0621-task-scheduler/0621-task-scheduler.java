class Solution {
    public int leastInterval(char[] tasks, int n) {
     HashMap<Character,Integer> hm=new HashMap<>();
        for(char c:tasks){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        pq.addAll(hm.values());
        int count=0;
        while(!pq.isEmpty()){
              int c=0;
             List<Integer> list=new ArrayList<>();
            for(int i=0;i<=n;i++){
                if(!pq.isEmpty()){
                    list.add(pq.poll());
                    c++;
                }
            }
            for(int i:list){
                i--;
                if(i>0)
                    pq.add(i);
            }
            
            count=count + (pq.isEmpty()?c:n+1);
            
        }
        return count;
        
   }
        
}
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
         int ts[][]=new int[n][3];
        for(int i=0;i<n;i++){
            ts[i][0]=i;
            ts[i][1]=tasks[i][0];
            ts[i][2]=tasks[i][1];
        }
        Arrays.sort(ts,(a,b)->a[1]-b[1]);
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]==b[2]?a[0]-b[0]:a[2]-b[2]);
        
        int i=0;
        int ans[]=new int[n];
        int ind=0;
       
        int time=0;
        while(ind<n){
            
            while(i<n && ts[i][1]<=time){
                  pq.add(ts[i++]);
            }
            
            if(pq.isEmpty()){
                time=ts[i][1];
                continue;
                
            }
            int cur[]=pq.poll();
            ans[ind++]=cur[0];   
            time+=cur[2];
            
            
        }
        return ans;
        
        
            
    }
}
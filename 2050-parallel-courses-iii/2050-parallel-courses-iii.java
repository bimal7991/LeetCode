class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
       int indegree[]=new int[n+1];
        int finishTime[]=new int[n+1];
        ArrayList<Integer> adjList[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
           adjList[i]=new ArrayList<>();
       for(int rel[]:relations){
           indegree[rel[1]]++;
           adjList[rel[0]].add(rel[1]);
       }
       Queue<Integer> q=new LinkedList<>();
       for(int i=1;i<=n;i++){
        if(indegree[i]==0){
             q.add(i);
             finishTime[i]=time[i-1];
        }
       }
        // System.out.println(Arrays.toString(finishTime));
       while(!q.isEmpty()){
           int s=q.size();
           for(int i=0;i<s;i++){
                 int p=q.poll();
                 for(int t:adjList[p]){
                     if(finishTime[t]<time[t-1]+finishTime[p]){
                        finishTime[t]=time[t-1]+finishTime[p];
                    }
                 indegree[t]--;  
                 if(indegree[t]==0){
                    q.add(t);
                    
                 }
            }
        }

       } 
       int max=0;
       for(int i=1;i<=n;i++){
           max=Math.max(finishTime[i],max);
       } 
       return max;  

    }
}
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n=graph.length;
        int finalState= (1<<n) -1;
        boolean vis[][]=new boolean[n][1<<n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(new int[]{i,1<<i,0});
            vis[i][1<<i]=true;
        }
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int currNode=curr[0];
            int currMask=curr[1];
            int currLength=curr[2];
            if(currMask==finalState)
                return currLength;
            for(int node:graph[currNode]){
                int newBitmask=currMask | 1<<node;
                if(vis[node][newBitmask])
                    continue;
                vis[node][newBitmask]=true;
                q.offer(new int[]{node,newBitmask,currLength+1});
            }
        }
        return -1;
        
    }
}
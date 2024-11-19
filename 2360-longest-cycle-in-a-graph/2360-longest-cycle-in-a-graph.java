class Solution {
   int max=-1;
    public int longestCycle(int[] edges) {
        int n=edges.length;
        boolean vis[]=new boolean[n];
        boolean dfsVis[]=new boolean[n];
        int dis[]=new int[n];
        for(int i=0;i<n;i++){
            dfs(vis,dfsVis,edges,i,0,dis);
        }
         return max;
    }
    void dfs(boolean vis[],boolean dfsVis[],int edges[],int node,int d,int dis[]){
        if(vis[node])
           return;
        vis[node]=true;
        dfsVis[node]=true;
        dis[node]=d;
        int c=edges[node];
        if(c==-1){
            dfsVis[node]=false;
            return;
        }
        if(!vis[c]){
            dfs(vis,dfsVis,edges,c,d+1,dis);
        }
        else{
            if(dfsVis[c]){
                max=Math.max(max,d-dis[c]+1);
            }
        }
        dfsVis[node]=false;   
    }
}
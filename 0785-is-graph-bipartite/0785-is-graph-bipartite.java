class Solution {
    public boolean isBipartite(int[][] graph) {
     
        
        int n=graph.length;
        boolean vis[]=new boolean[n];
        int color[]=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false)
            if(dfs(i,vis,0,graph,color)==false){
                return false;
            }
        }
        return true;
    }
    boolean dfs(int v,boolean vis[],int c,int graph[][],int color[]){
        vis[v]=true;
        color[v]=c;
        for(int u:graph[v]){
            if(!vis[u]){
                 if(dfs(u,vis,1^c ,graph,color)==false)
                     return false;
            }
            else{
                if(color[v]==color[u])
                    return false;
            }
        }
        return true;
    }
}
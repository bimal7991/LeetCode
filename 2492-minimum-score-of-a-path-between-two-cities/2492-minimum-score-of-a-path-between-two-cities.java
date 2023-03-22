class Solution {
    public int minScore(int n, int[][] roads) {
        int parent[]=new int[n+1];
        for(int i=1;i<=n;i++)
            parent[i]=i;
        for(int r[]:roads){
            if(find(r[0],parent)!=find(r[1],parent))
            union(r[0],r[1],parent);
        }
        int min=Integer.MAX_VALUE;
        for(int r[]:roads){
            if(find(r[0],parent)==find(r[1],parent) && parent[r[0]]==1)
               min=Math.min(r[2],min);
            
        }
        return min;
    }
    public int find(int u,int parent[]){
        if(parent[u]==u)
            return u;
        return parent[u]=find(parent[u],parent);
    }
    void union(int u,int v,int parent[]){
        u=find(u,parent);
        v=find(v,parent);
        if(u==1){
            parent[v]=u;
        }
        else if(v==1){
            parent[u]=v;
        }
        else
            parent[v]=u;
    }
}
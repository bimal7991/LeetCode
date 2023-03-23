class Solution {
    public int makeConnected(int n, int[][] con) {
        if(con.length<n-1)
            return -1;
        int parent[]=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
        for(int c[]:con){
            union(c[0],c[1],parent);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(find(i,parent)!=0)
            {
                count++;
                union(0,i,parent);
            }
            
        }
        return count;
        
    }
    int find(int u,int parent[]){
        if(parent[u]==u)
            return u;
        return parent[u]=find(parent[u],parent);
    }
    void union(int u,int v,int parent[]){
        u=find(u,parent);
        v=find(v,parent);
        if(u==0)
            parent[v]=u;
        else if(v==0)
            parent[u]=v;
        else
            parent[u]=v;
    }
}
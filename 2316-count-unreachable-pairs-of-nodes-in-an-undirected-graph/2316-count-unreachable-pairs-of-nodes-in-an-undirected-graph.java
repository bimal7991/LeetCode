class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<Integer> arr[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            arr[i]=new ArrayList<>();
        }
        for(int e[]:edges){
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
        int vis[]=new int[n];
        
        long res=((long)n*(long)(n-1))/2;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                count=0;
                dfs(vis,arr,i);
               // System.out.println(count);
                res=res-(count*(count-1))/2;
            }
        } 
        return res;
    }
    long count=0;
    void dfs(int vis[],ArrayList<Integer> arr[],int node){
        if(vis[node]==1)
            return ;
       vis[node]=1;
       count++;
        for(int child:arr[node]){
            if(vis[child]==0){
              dfs(vis,arr,child);
            }
        }
       
    }
}
class Solution {
    int t=1;
   public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
	   List<Integer> arr[]=new ArrayList[n];
       for(int i=0;i<n;i++){
           arr[i]=new ArrayList<>();
       }
       for(List<Integer> l:connections){
           arr[l.get(0)].add(l.get(1));
           arr[l.get(1)].add(l.get(0));
       }
       List<List<Integer>> ans=new ArrayList<>();
       int low[]=new int[n];
       int dis[]=new int[n];
       int vis[]=new int[n];
       dfs(0,dis,low,vis,arr,ans,-1);
       
       return ans;
   }
  public void dfs(int u,int dis[],int low[],int vis[],List<Integer>[] arr,List<List<Integer>> ans,int par){
      dis[u]=t;
      low[u]=t;
      t++;
      vis[u]=1;
      for(int v:arr[u]){
          if(v==par)
              continue;
          if(vis[v]==0){
              dfs(v,dis,low,vis,arr,ans,u);
              low[u]=Math.min(low[u],low[v]);
              if(low[v]>dis[u]){
                  ans.add(Arrays.asList(u, v));
              }
          }
          else{
              low[u]=Math.min(low[u],low[v]);
          }
      }
  }
    

}
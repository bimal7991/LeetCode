class Solution {
    int dis[]=new int[100001];
     
    public int longestPath(int[] parent, String s) {
        int n=parent.length;
       ArrayList<Integer> list[]=new ArrayList[n];
        for(int i=0;i<n;i++)
            list[i]=new ArrayList<>();
        for(int i=1;i<parent.length;i++){
            list[parent[i]].add(i);
        }
        int ans[]=new int[1];
        ans[0]=1;
        dfs(list,s,0,ans);
        return ans[0];
    }
    public void dfs(ArrayList<Integer> list[],String s,int cur,int ans[]){
        dis[cur]=1;
        for(int child:list[cur]){
            dfs(list,s,child,ans);
            if(s.charAt(cur)!=s.charAt(child)){
              ans[0]=Math.max(ans[0],dis[child]+dis[cur]);
              dis[cur]=Math.max(dis[cur],dis[child]+1);
            }
        }
    }
}
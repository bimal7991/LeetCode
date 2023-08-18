class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if(roads.length==0)
            return 0;
        int out[]=new int[n];
        HashMap<String,Integer> hm=new HashMap<>();
        for(int r[]:roads){
          out[r[0]]++;
          out[r[1]]++;
          String key=""+r[0]+"*"+r[1];
          hm.put(key,1);
          String key2=""+r[1]+"*"+r[0];
          hm.put(key2,1);  
            
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    int count=out[i]+out[j];
                    String key=""+i+"*"+j;
                    String key2=""+j+"*"+i;
                    if(hm.containsKey(key) || hm.containsKey(key2))
                        count--;
                    max=Math.max(max,count);
                }
            }
        }
        return max;
    }
    int dfs(ArrayList<Integer> graph[],int node,boolean vis[]){
        if(vis[node])
            return 0;
        vis[node]=true;
        int count=1;
        for(int parent:graph[node]){
            if(!vis[parent]){
                 count+=dfs(graph,parent,vis);
            }
             
        }
        return count;
    }
}
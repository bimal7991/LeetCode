class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer> arr[]=new ArrayList[n];
        for(int i=0;i<n;i++)
            arr[i]=new ArrayList<>();
        for(int e[]:edges){
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[n];
        q.add(source);
        vis[source]=true;
        while(!q.isEmpty()){
            if(vis[destination])
                return true;
            int node=q.poll();
            for(int i:arr[node]){
                if(!vis[i])
                {
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
        return false;
        
    }
}
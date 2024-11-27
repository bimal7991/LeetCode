class Solution {
    int dis[];
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<Integer> arr[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            arr[i].add(i+1);
        }
        int ans[]=new int[queries.length];
        
        dis=new int[n];
        for(int i=0;i<n;i++)
            dis[i]=i;
            int i=0;
        for(int q[]:queries){
            arr[q[0]].add(q[1]);
            int res=bfs(arr,n,q[0]);
            ans[i++]=res;
        }
        return ans;
    }
    int bfs(ArrayList<Integer> arr[],int n,int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int node=q.poll();
             for(int c:arr[node]){
                 if(dis[node]+1<dis[c]){
                     dis[c]=dis[node]+1;
                     q.add(c);
                 }
             }
        }
        return dis[n-1];
    }
}
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<Integer> arr[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            arr[i].add(i+1);
        }
        int ans[]=new int[queries.length];
        int i=0;
        for(int q[]:queries){
            arr[q[0]].add(q[1]);
            int res=bfs(arr,n);
            ans[i++]=res;
        }
        return ans;
    }
    int bfs(ArrayList<Integer> arr[],int n){
        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        dis[0]=0;
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
class Solution {
    public int findCircleNum(int[][] con) {
        int n=con.length;
        ArrayList<Integer> arr[]=new ArrayList[n];
        for(int i=0;i<n;i++)
            arr[i]=new ArrayList<Integer>();
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(con[i][j]==1){
                    arr[i].add(j);
                    arr[j].add(i);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,arr,vis);
                count++;
            }
        }
        return count;
    }
    void dfs(int child,ArrayList<Integer> arr[],boolean vis[]){
        if(vis[child])
            return;
        vis[child]=true;
        for(int i:arr[child]){
            if(!vis[i]){
                dfs(i,arr,vis);
            }
        }
    }
}
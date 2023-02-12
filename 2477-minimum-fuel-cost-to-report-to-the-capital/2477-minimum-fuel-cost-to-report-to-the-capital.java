class Solution {
    long ans=0;
    public long minimumFuelCost(int[][] roads, int s) {
        int n=roads.length;
        ArrayList<Integer> arr[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=new ArrayList<Integer>();
        }
        for(int r[]:roads){
            arr[r[0]].add(r[1]);
            arr[r[1]].add(r[0]);
        }
        dfs(0,0,arr,s);
        return ans;
    }
    int dfs(int node,int parent,ArrayList<Integer> arr[],int s){
        int count=1;
        for(int x:arr[node]){
            if(x==parent)
                continue;
            count+=dfs(x,node,arr,s);
        }
        if(node!=0){
            ans+=(count+s-1)/s;
        }
        return count;
    }
}
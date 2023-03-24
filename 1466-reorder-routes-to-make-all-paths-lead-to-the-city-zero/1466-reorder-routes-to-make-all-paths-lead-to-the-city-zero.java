class Solution {
    int count=0;
    public int minReorder(int n, int[][] connections) {
        ArrayList<Integer> arr[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            arr[i]=new ArrayList<>();
        }
        HashMap<String,Integer> hm=new HashMap<>();
        for(int con[]:connections){
            String key=""+con[0]+"*"+con[1];
            hm.put(key,1);
            arr[con[0]].add(con[1]);
            arr[con[1]].add(con[0]);
        }
        int vis[]=new int[n];
        dfs(arr,vis,hm,0);
        return count;
    }
    void dfs(ArrayList<Integer> arr[], int vis[],HashMap<String,Integer> hm,int node){
        if(vis[node]==1)
            return ;
        vis[node]=1;
        for(int child:arr[node]){
            if(vis[child]==0){
                String key=""+node+"*"+child;
                if(hm.containsKey(key))
                    count++;
                dfs(arr,vis,hm,child);
                
            }
        }
    }
}
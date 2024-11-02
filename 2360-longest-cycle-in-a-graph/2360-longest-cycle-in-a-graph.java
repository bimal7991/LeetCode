class Solution {
    int max=-1;
    public int longestCycle(int[] edges) {
               int n=edges.length;
                ArrayList<Integer> arr[]=new ArrayList[n];
				for(int i=0;i<n;i++) {
					arr[i]=new ArrayList<Integer>();
				}
				for(int i=0;i<edges.length;i++) {
					int u=i,v=edges[i];
                         if(v!=-1){
					arr[u].add(v);
                   }
				}
                boolean vis[]=new boolean[n];
                boolean dfs[]=new boolean[n];
                int dis[]=new int[n];
                for(int i=0;i<n;i++){
                    if(!vis[i])
                        dfs(i,arr,vis,dfs,dis,0);
                }
				
				// bfs(inDegree,arr);
				// int max=-1;
				// for(int i=0;i<n;i++){
				// if(inDegree[i]>0){
				// max=Math.max(max,getLength(inDegree,edges,i));
				// }
				// }		
              return max;   
				
			}
      // int getLength(int inDegree[],int edges[],int node){
      //     int l=0;
      //     while(inDegree[node]!=0){
      //         inDegree[node]--;
      //         node=edges[node];
      //         l++;
      //     }
      //     return l;
      // }
    public void dfs(int node,ArrayList<Integer> arr[],boolean vis[],boolean dfs[],int dis[],int d){
        if(vis[node])
            return;
        vis[node]=true;
        dfs[node]=true;
        dis[node]=d;
        for(int child:arr[node]){
            if(!vis[child]){
                dfs(child,arr,vis,dfs,dis,d+1);
            }
            else{
                if(dfs[child]){
                    // System.out.println(d-dis[child]);
                    max=Math.max(max,d-dis[child]+1);
                }
            }
        }
        dfs[node]=false;
    }
        
    
   public void bfs( int[] inDegree, ArrayList<Integer>[] arr) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}		
		while(!q.isEmpty()) {
			int parent=q.poll();
			for(int child:arr[parent]) {
				inDegree[child]--;
				if(inDegree[child]==0) {
					q.add(child);
				}
			}
		}
	}
}
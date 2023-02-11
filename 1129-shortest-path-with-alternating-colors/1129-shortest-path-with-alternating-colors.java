class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            ArrayList<int[]> arr[]=new ArrayList[n];
			
		
			for(int i=0;i<n;i++) {
				arr[i]=new ArrayList<int[]>();
			
			}
			for(int e[]:redEdges){
                arr[e[0]].add(new int[]{e[1],0});
            }
           for(int e[]:blueEdges){
                arr[e[0]].add(new int[]{e[1],1});
          }
        
          int dis[]=new int[n];
          int vis[][]=new int[n][2];
          for(int i=1;i<n;i++){
              vis[i][0]=2*n;
              vis[i][1]=2*n;
          }
       
        
         Queue<int[]> queue=new LinkedList<int[]>();
	
		
		queue.add(new int[]{0,0});
        queue.add(new int[]{0,1});
    
    
		//System.out.println(node);
		while(!queue.isEmpty()) {
			int curr[]=queue.poll();
            int node=curr[0];
            int c=curr[1];
			for(int child[]:arr[node]) {
				if(c==0 && child[1]==1 && vis[child[0]][child[1]]==2*n ) {
					vis[child[0]][child[1]]=vis[node][c]+1;
                    queue.add(child);
				}
                if(c==1 && child[1]==0 && vis[child[0]][child[1]]==2*n) {
					vis[child[0]][child[1]]=vis[node][c]+1;
                    queue.add(child);
                    
				}
                
			}
			
		}
        for (int i=0;i<n;i++) {
          int cand = Math.min(vis[i][0],vis[i][1]);
          dis[i] = cand==n*2? -1: cand;  
        } 
       
        return dis;
    }
}
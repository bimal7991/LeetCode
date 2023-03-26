class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
                int inDegree[]=new int[n];
                ArrayList<Integer> arr[]=new ArrayList[n];
				for(int i=0;i<n;i++) {
					arr[i]=new ArrayList<Integer>();
				}
				for(int i=0;i<edges.length;i++) {
					int u=i,v=edges[i];
                         if(v!=-1){
					arr[u].add(v);
               
                    inDegree[v]++;	
                         }
				}

				
				ArrayList<Integer> ans=new ArrayList<Integer>();
				bfs(inDegree,ans,arr);
				int max=-1;
			    for(int i=0;i<n;i++){
                    if(inDegree[i]>0){
                        max=Math.max(max,getLength(inDegree,edges,i));
                    }
                }		
              return max;   
				
			}
      int getLength(int inDegree[],int edges[],int node){
          int l=0;
          while(inDegree[node]!=0){
              inDegree[node]--;
              node=edges[node];
              l++;
          }
          return l;
      }
        
    
   public void bfs( int[] inDegree, ArrayList<Integer> ans, ArrayList<Integer>[] arr) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i]==0) {
				q.add(i);
			}
		}		
		while(!q.isEmpty()) {
			int parent=q.poll();
			ans.add(parent);
			for(int child:arr[parent]) {
				inDegree[child]--;
				if(inDegree[child]==0) {
					q.add(child);
				}
			}
		}
	}
}
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
       List<List<Integer>> list=new ArrayList<>();
        int vis[]=new int[n];
        Stack<Integer> path=new Stack<Integer>();
        path.push(0);
        dfs(0,n-1,vis,path,graph,list);
            return list;
    }
    void dfs(int node,int dest,int vis[],Stack<Integer> path,int arr[][],List<List<Integer>> list)
	{
		
		
		if(node==dest) {
			//System.out.println(path);
            list.add(new ArrayList(path));
		}
		
			for(int i=0;i<arr[node].length;i++)
			{
				int child=arr[node][i]; 
	    
                    path.push(child);
	            	dfs(child,dest,vis,path,arr,list);	
                   
	            	path.pop();
	            	
	            
			}
		
		
		
	}
}
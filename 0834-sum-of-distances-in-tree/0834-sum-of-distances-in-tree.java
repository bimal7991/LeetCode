class Solution {
     int count[];
    int res[];

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<Integer> arr[]=new ArrayList[n];
		for(int i=0;i<n;i++) {
			arr[i]=new ArrayList<Integer>();
		}
        
        count=new int[n];
        res=new int[n];
		for(int e[]:edges){
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
         dfs(0,-1,arr);
         dfs2(0,-1,arr);    
        
        return res;
    }
    
    void dfs(int cur,int parent, ArrayList<Integer>[] arr) {    
	 
	
		for(int child:arr[cur]) {
            if(child==parent)
                continue;
            dfs(child,cur,arr);
            count[cur]+=count[child];
            res[cur]+=res[child]+count[child]; 
		}
        count[cur]++;
   }
    void dfs2(int cur,int parent, ArrayList<Integer>[] arr) {    
	 
	
		for(int child:arr[cur]) {
            if(child==parent)
                continue;
            
            res[child]=res[cur]-count[child]+res.length-count[child]; 
            dfs2(child,cur,arr);
		}
       
   }
}
    
    

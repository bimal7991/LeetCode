class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        ArrayList<Integer> arr[]=new ArrayList[edges.length];
        for(int i=0;i<edges.length;i++){
            arr[i]=new ArrayList<>();
        }
        
        int dis1[]=new int[edges.length];
        int dis2[]=new int[edges.length];
        
        for(int i=0;i<edges.length;i++){
            if(edges[i]==-1)
                continue;
            arr[i].add(edges[i]);
        }
        Arrays.fill(dis1,Integer.MAX_VALUE);
        Arrays.fill(dis2,Integer.MAX_VALUE);
        sortestDistance(node1,arr,dis1);
        sortestDistance(node2,arr,dis2);
        int min=Integer.MAX_VALUE;
        int ind=-1;
        for(int i=0;i<edges.length;i++){
            int max=Math.max(dis1[i],dis2[i]);
            if(max<min){
                min=max;
                ind=i;
            }  
        }
        if(min==Integer.MAX_VALUE)
            return -1;
        return ind;
        
        
        
    }
   void sortestDistance(int node, ArrayList<Integer>[] arr,int dis[]) {	
		Queue<Integer> queue=new LinkedList<Integer>();
		dis[node]=0;
		queue.add(node);
		//System.out.println(node);
		while(!queue.isEmpty()) {
			int curr=queue.peek();
			queue.remove();
			for(int child:arr[curr]) {
				
				if(dis[curr]+1<dis[child]) {
					//System.out.println(child);
					queue.add(child);
					dis[child]=dis[curr]+1;
				}
			}
			
		}
	}
}
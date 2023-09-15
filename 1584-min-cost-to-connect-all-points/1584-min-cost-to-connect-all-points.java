class Solution {
    public int minCostConnectPoints(int[][] points) {
        int sum=0;
        int n=points.length;
        ArrayList<NodeDis> arr[]=new ArrayList[n+1];
	  			for(int i=0;i<=n;i++) {
	  				arr[i]=new ArrayList<NodeDis>();
	  			}
        
        for(int i=0;i<n;i++){
           
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                int dis=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                arr[i].add(new NodeDis(j,dis));
	  				arr[j].add(new NodeDis(i, dis));
            }
           
        }
	  	return 	minimumSpanningTree(0, arr,n,points);
        
        
        
    }
   public int minimumSpanningTree(int start, ArrayList<NodeDis>[] arr, int n,int[][] points) {
		// TODO Auto-generated method stub
		int key[]=new int[n];
		Arrays.fill(key, 9999999);
		boolean mst[]=new boolean[n];
		Arrays.fill(mst, false);
		int parent[]=new int[n];
		Arrays.fill(parent, -1);
		PriorityQueue<NodeDis> pq=new PriorityQueue<NodeDis>(n,new NodeDis());
		pq.add(new NodeDis(0,0));
		key[start]=0;
       int sum=0;
		while(!pq.isEmpty()) {
			NodeDis par=pq.poll();
            if(mst[par.getNode()])
                continue;
			mst[par.getNode()]=true;
            sum+=par.getWeight();    
			for(NodeDis child:arr[par.getNode()]) {
				if(mst[child.getNode()]==false) {
					key[child.getNode()]=child.getWeight();
					parent[child.getNode()]=par.getNode();
					pq.add(new NodeDis(child.getNode(),key[child.getNode()]));
				}
			}
		}
      
// 		for(int i=1;i<n;i++) {
//             int dis=Math.abs(points[parent[i]][0]-points[i][0])+Math.abs(points[parent[i]][1]-points[i][1]);
//             sum=sum+dis;
            
// 		 // System.out.println(parent[i]+" -> "+i);
//            // System.out.println(sum);
// 		}
       return sum;
	}

    
}
class NodeDis implements Comparator<NodeDis>{
	int node;
	int weight;
	public NodeDis() {
		
	}
	
	public NodeDis(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
	public int getNode() {
		return node;
	}
	public void setNode(int node) {
		this.node = node;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public int compare(NodeDis n1, NodeDis n2) {
		// TODO Auto-generated method stub
		if(n1.weight<n2.weight)
			return -1;
		 if(n1.weight>n2.weight)
			 return 1;
		return 0;
	}
	
	
}

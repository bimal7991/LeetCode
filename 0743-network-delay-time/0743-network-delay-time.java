class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
          ArrayList<NodeDis> arr[]=new ArrayList[n+1];
	  			for(int i=0;i<=n;i++) {
	  				arr[i]=new ArrayList<NodeDis>();
	  			}
	  			
	  			for(int i=0;i<times.length;i++) {
	  				int u=times[i][0],v=times[i][1],w=times[i][2];
	  				arr[u].add(new NodeDis(v,w));
	  				
	  				
	  			}
	  			int dis[]=new int[n+1];
	  			Arrays.fill(dis, 999999);
	  			sortestDistance(k, arr,dis);
	  			int max=-9999999;
	  			for(int i=1;i<=n;i++) {
                    System.out.print(dis[i]+" ");
                    if(dis[i]==999999)
                        return -1;
                    else 
	  				max=Math.max(dis[i],max);
	  			}
        return max;
        
    }
        
  public  void sortestDistance(int i, ArrayList<NodeDis>[] arr, int[] dis) {
		PriorityQueue<NodeDis> pq=new PriorityQueue<NodeDis>((a,b)->a.weight-b.weight); 
		
		pq.add(new NodeDis(i,0));
		dis[i]=0;
		while(!pq.isEmpty()) {
			NodeDis parent=pq.poll();
			for(NodeDis child: arr[parent.getNode()]) {
				if(dis[parent.getNode()]+child.getWeight()<dis[child.getNode()]) {
					dis[child.getNode()]=dis[parent.getNode()]+child.getWeight();
					pq.add(new NodeDis(child.getNode(),dis[child.getNode()]));
				}
			}
			
		}
		
	}
}
class NodeDis {
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
	
	
	
}

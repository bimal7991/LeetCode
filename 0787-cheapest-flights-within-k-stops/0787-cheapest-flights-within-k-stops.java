class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
           List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                for (int[] neighbour : adj.get(curr[0])) {
                    int price = neighbour[1], neighbourNode = neighbour[0];
                    if (price + curr[1] >= minCost[neighbourNode]) continue;
                    minCost[neighbourNode] = price + curr[1];
                    q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
                }
            }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
    void sortestDistance(int node, ArrayList<Integer>[] arr, int[] dis, HashMap<String, Integer> weight,int k) {	
			Queue<Integer> queue=new LinkedList<Integer>();
			dis[node]=0;
			queue.add(node);
			//System.out.println(node);
        int stops=0;
			while(!queue.isEmpty() && stops<=k) {
				
                int size=queue.size();
                while(size-->0){
                int curr=queue.peek();
				queue.remove();
				for(int child:arr[curr]) {
					//System.out.println(weight.get(new Weight(curr,child)));
					if(dis[curr]+weight.get(""+curr+","+child)<dis[child]) {
						//System.out.println(child);
						queue.add(child);
						dis[child]=dis[curr]+weight.get(""+curr+","+child);
					}
				  }
                }
                stops++;
				
			}
		}
}
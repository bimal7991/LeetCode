class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
           ArrayList<ArrayList<Pair>> arr=new ArrayList<>();
  			for(int i=0;i<n;i++) {
  				arr.add(new ArrayList<Pair>());
  			}
  			
  			for(int fl[]:flights) {
  				arr.get(fl[0]).add(new Pair(fl[1],fl[2]));
  			}
            int dis[]=new int[n];
  			Arrays.fill(dis, Integer.MAX_VALUE);
  			Queue<Tuple> queue=new LinkedList<Tuple>();
			dis[src]=0;
			queue.add(new Tuple(0,src,0));
			//System.out.println(node);
            int stops=0;
			while(!queue.isEmpty()) {
				Tuple t=queue.peek();
                queue.remove();
                int stop=t.a;
                int cur=t.b;
                int d=t.c;
                if(stop>k)
                    continue;
                
				for(Pair child:arr.get(cur)) {
                    int adjNode = child.a; 
                    int edW = child.b; 
					//System.out.println(weight.get(new Weight(curr,child)));
					if(d+edW<dis[adjNode] && stop<=k) {
						//System.out.println(child);
						queue.add(new Tuple(stop+1,adjNode,d+edW));
						dis[adjNode]=d+edW;
				}
				
			}
		}
          
        
          return dis[dst]==Integer.MAX_VALUE?-1:dis[dst];
        
    }
}
class Pair{
    int a,b;
    Pair(int a,int b){
       this.a=a;
        this.b=b; 
    }
    Pair(){}
}
class Tuple{
    int a,b,c;
    Tuple(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    Tuple(){}
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Node>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<Node>());
        for(int f[]:flights){
            list.get(f[0]).add(new Node(f[1],f[2]));
        }
        Queue<int[]> q=new LinkedList<>();
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        q.add(new int[]{src,0,0});
            
            while(!q.isEmpty()){
                 int curNode[]=q.poll();
                 int stop=curNode[2];
                if(stop>k)
                     continue;
                for(Node child:list.get(curNode[0])){
                    if(child.dis+curNode[1]<dist[child.node]){
                        dist[child.node]=child.dis+curNode[1];
                        q.add(new int[]{child.node,child.dis+curNode[1],stop+1});
                        
                    }
                }
                 
            }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
        
    }
}

class Node{
    int node;
    int dis;
    Node(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
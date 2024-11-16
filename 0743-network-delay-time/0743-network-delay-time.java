class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<NodeDis> list[]=new ArrayList[n];
        for(int i=0;i<n;i++)
            list[i]=new ArrayList<>();
        for(int t[]:times){
            list[t[0]-1].add(new NodeDis(t[1]-1,t[2]));
        }
        int res[]=new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[k-1]=0;
        PriorityQueue<NodeDis> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new NodeDis(k-1,0));
        while(!pq.isEmpty()){
            NodeDis curr=pq.poll();
            for(NodeDis next:list[curr.node]){
                if(res[next.node]>res[curr.node]+next.weight){
                    res[next.node]=res[curr.node]+next.weight;
                    pq.add(new NodeDis(next.node,res[next.node]));
                }
            }
        }
        // System.out.println(Arrays.toString(res));
        int max=0;
        for(int i:res)
            max=Math.max(max,i);
        return max==Integer.MAX_VALUE?-1:max;
    }
}
class NodeDis{
    int node;
    int weight;
    NodeDis(int n,int w){
        node=n;
        weight=w;
    }
}
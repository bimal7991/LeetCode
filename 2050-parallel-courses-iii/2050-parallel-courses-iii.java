class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer> list[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<>();
        }
        int indeg[]=new int[n];
        for(int rel[]:relations){
            list[rel[0]-1].add(rel[1]-1);
            indeg[rel[1]-1]++;
        }
        Queue<Integer> q=new LinkedList<>();
        int res[]=new int[n];
        for(int i=0;i<n;i++)
            if(indeg[i]==0){
                q.add(i);
                res[i]=time[i];
            }
        
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                int u=q.poll();
                for(int v:list[u])
                {
                    if(res[v]<res[u]+time[v])
                        res[v]=res[u]+time[v];
                    indeg[v]--;
                    if(indeg[v]==0)
                        q.add(v);
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++)
            max=Math.max(max,res[i]);
        return max;
    }
}
class Solution {
    List<int[]> res;
    public int[][] validArrangement(int[][] pairs) {
        // System.out.println(pairs.length);
        HashMap<Integer,Integer> hm=new HashMap<>();
        HashMap<Integer,Queue<Integer>> graph=new HashMap<>();
        for(int p[]:pairs){
            hm.put(p[0],hm.getOrDefault(p[0],0)+1);
            hm.put(p[1],hm.getOrDefault(p[1],0)-1);
        }
        for(int p[]:pairs){
            if(!graph.containsKey(p[0])){
                Queue<Integer> pq=new LinkedList<>();
                pq.add(p[1]);
                graph.put(p[0],pq);
            }
            else{
                Queue<Integer> pq=graph.get(p[0]);
                pq.add(p[1]);
                graph.put(p[0],pq);
            }
        }
        res=new ArrayList<>();
        int max=0;
        for(int key:hm.keySet()){
            if(hm.get(key)>hm.getOrDefault(max,Integer.MIN_VALUE)){
                max=key;
            }
        }
        // System.out.println(max);
        HashSet<String> visited=new HashSet<>();
        dfs(max,graph,hm,visited);
        // System.out.println(res.size());
        int arr[][]=new int[res.size()][2];
        for(int i=0;i<res.size();i++)
            arr[i]=res.get(res.size()-i-1);
        return arr;

    }
   public void dfs(int key,HashMap<Integer,Queue<Integer>> graph, HashMap<Integer,Integer> hm,HashSet<String> visited){
        if(!graph.containsKey(key))
            return;
        Queue<Integer> pq=graph.get(key);
        while(!pq.isEmpty()){
                int c=pq.poll();
                
                dfs(c,graph,hm,visited);
            res.add(new int[]{key,c});
                
            
                
        }
    }
}
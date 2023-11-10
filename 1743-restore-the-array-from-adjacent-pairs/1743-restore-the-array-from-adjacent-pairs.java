class Solution {
    public int[] restoreArray(int[][] pair) {
        HashMap<Integer,List<Integer>> hm=new HashMap<Integer,List<Integer>>();
       
        for(int p[]:pair){
            if(hm.containsKey(p[0])){
                List<Integer> list=hm.get(p[0]);
                list.add(p[1]);
                hm.put(p[0],list);
            }
            else
            {
                List<Integer> list=new ArrayList<>();
                list.add(p[1]);
                hm.put(p[0],list);
            }
            if(hm.containsKey(p[1])){
                List<Integer> list=hm.get(p[1]);
                list.add(p[0]);
                hm.put(p[1],list);
            }
            else
            {
                List<Integer> list=new ArrayList<>();
                list.add(p[0]);
                hm.put(p[1],list);
            }
            
        }
        int first=-1;
        for(int k:hm.keySet()){
            if(hm.get(k).size()==1)
                first=k;
        }
        int ans[]=new int[pair.length+1];
        HashMap<Integer,Boolean> vis=new HashMap<>();
        Arrays.fill(ans,Integer.MIN_VALUE);
        dfs(first,ans,hm,0,vis);
        return ans;
        
    }
    void dfs(int node,int ans[],HashMap<Integer,List<Integer>> hm,int index,HashMap<Integer,Boolean> vis){
        if(vis.containsKey(node))
            return;
        ans[index]=node;
        vis.put(node,true);
        for(int child:hm.get(node)){
            if(!vis.containsKey(child)){
                dfs(child,ans,hm,index+1,vis);
            }
        }
    }
}
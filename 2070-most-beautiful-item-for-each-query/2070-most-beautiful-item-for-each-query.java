class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        for(int it[]:items){
            if(hm.containsKey(it[0])){
                hm.put(it[0],Math.max(hm.get(it[0]),it[1]));
            }
            else{
                hm.put(it[0],it[1]);
            }
        }
        TreeMap<Integer,Integer> maxP=new TreeMap<Integer,Integer>();
        int max=0;
        for(int k:hm.keySet()){
            max=Math.max(max,hm.get(k));
            maxP.put(k,max);
        }
        
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            Integer k=maxP.floorKey(queries[i]);
            ans[i]= k==null?0:maxP.get(k);
                
        }
        return ans;
        
    }
}
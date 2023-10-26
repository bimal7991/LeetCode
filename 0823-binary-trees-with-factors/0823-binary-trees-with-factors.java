class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        Arrays.sort(arr);
        HashMap<Integer,Long> hm=new HashMap<>();
        long count=1;
        hm.put(arr[0],count);
        for(int i=1;i<arr.length;i++){
            count=1;
            for(Integer key:hm.keySet()){
                if( arr[i]%key ==0 && hm.containsKey(arr[i]/key) )
                    count=count+hm.get(key)*hm.get(arr[i]/key);
            }
            hm.put(arr[i],count);
            
        }
        int ans=0;
        for(Integer key:hm.keySet()){
            ans=(int)(ans+hm.get(key)%1000000007)%1000000007;
        }
        return ans;
        
    }
}
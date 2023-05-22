class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        ArrayList<Integer> arr[]=new ArrayList[nums.length+1];
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i=0;i<=nums.length;i++)
            arr[i]=new ArrayList<>();
        for(Integer i: hm.keySet()){
            int f=hm.get(i);
            arr[f].add(i);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--){
            ans.addAll(arr[i]);
            if(ans.size()>=k)
                break;
        }
        return ans.stream().mapToInt(i -> i).toArray();
        
        
    }
   
    
}
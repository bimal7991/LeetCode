class Solution {
    public int maximumBeauty(int[] nums, int k) {
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        for(int n:nums){
            int left=n-k;
            int right=n+k+1;
            hm.put(left,hm.getOrDefault(left,0)+1);
            hm.put(right,hm.getOrDefault(right,0)-1);
        }
        int max=0;
        int sum=0;
        for(int key:hm.keySet()){
            sum=sum+hm.get(key);
            max=Math.max(max,sum);
        }
        return max;
    }
}
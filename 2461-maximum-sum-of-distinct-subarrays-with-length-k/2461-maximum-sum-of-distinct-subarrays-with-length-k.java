class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i=0,j=0;
        long sum=0;
        long max=0;
        while(j<nums.length){
            sum=sum+nums[j];
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            if(j-i+1<k)
                j++;
            else if(j-i+1==k){
                
                if(hm.size()==k){
                    max=Math.max(max,sum);
                }
                    hm.put(nums[i],hm.get(nums[i])-1);
                    sum=sum-nums[i];
                    if(hm.get(nums[i])==0)
                        hm.remove(nums[i]);
                    i++;
                j++;
            }
            
        }
        return max;
    }
}
class Solution {
    public int getLargestOutlier(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums)
            hm.put(i,hm.getOrDefault(i,0)+1);
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        for(int i=nums.length-1;i>=0;i--){
            
            if((sum-nums[i])%2==0){
                int half=(sum-nums[i])/2;
                if(half==nums[i] && hm.getOrDefault(half,0)>1)
                     return nums[i];
                else if(half!=nums[i] && hm.getOrDefault(half,0)>=1)
                    return nums[i];
            }
        }
        return -1;
    }
}
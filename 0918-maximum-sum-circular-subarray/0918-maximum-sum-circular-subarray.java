class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=nums[0];
        int maxHere=nums[0];
        int minHere=nums[0];
        int max=nums[0];
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            maxHere=Math.max(maxHere+nums[i],nums[i]);
            max=Math.max(maxHere,max);
            
            minHere=Math.min(minHere+nums[i],nums[i]);
            min=Math.min(minHere,min);
            
            sum=sum+nums[i];
        }
        if(sum==min)
            return max;
        return Math.max(max,sum-min);
        
    }
}
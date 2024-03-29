class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=0;
        long n=nums.length;
        long count=0;
        for(int i:nums)
            max=Math.max(max,i);
         int maxCount=0,i=0,j=0;
        while(j<nums.length){
            if(nums[j]==max)
                maxCount++;
            while(maxCount>=k){
                if(nums[i]==max)
                    maxCount--;
                i++;
            }
            count=count+(j-i+1);
            j++;
        }
        return (n*(n+1))/2-count;
    }
}
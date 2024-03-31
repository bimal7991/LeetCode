class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int i=-1,minIndex=-1,maxIndex=-1,j=0;
        long count=0;
        while(j<nums.length){
            if(nums[j]<minK || nums[j]>maxK)
                i=j;
            
            if(nums[j]==minK)
                minIndex=j;
            if(nums[j]==maxK)
                maxIndex=j;
            
            count=count+Math.max(0,Math.min(minIndex,maxIndex)-i);
            j++;
        }
        return count;
    }
}
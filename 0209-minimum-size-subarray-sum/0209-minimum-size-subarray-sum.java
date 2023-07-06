class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int i=0,j=0;
        long sum=0;
        int min=nums.length+1;
        while(j<nums.length){
            sum=sum+nums[j];
           
                while(i<=j && sum>=k){
                    min=Math.min(min,(j-i+1));
                    sum=sum-nums[i];
                    i++;
                }
            
            j++;
        }
        return min==nums.length+1?0:min;
    }
}
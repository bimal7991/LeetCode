class Solution {
    public int minPatches(int[] nums, int n) {
        int count=0;
        long sum=0;
        int i=0;
        
        while(i<nums.length && sum<=n){
            if(nums[i]>sum+1){
                sum+=(sum+1);
                count++;
            }
            else
            {
             sum=sum+nums[i];
             i++;   
            }
            if(sum==n)
                break;
        }
        while(sum<n){
        sum+=(sum+1);
        count++;
       }
        return count;
    }
    
}
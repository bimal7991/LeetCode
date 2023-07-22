class Solution {
    public int splitArray(int[] nums, int k) {
        long low=0;
        long high=1000000000;
        long ans=0;
        while(low<=high){
            long mid=(low+high)/2;
            if(devidedCount(mid,nums,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return (int)ans;
        
    }
  boolean devidedCount(long mid,int nums[],int k){
        int count=1,i=0;
        long sum=0;
        while(i<nums.length){
            if(nums[i]>mid)
                return false;
            if(sum+nums[i]<=mid){
                sum=sum+nums[i];
            }else{
                sum=nums[i];
                count++;
            }
            i++;
        }
        return count<=k;
    }
}
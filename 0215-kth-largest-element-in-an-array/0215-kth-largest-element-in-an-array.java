class Solution {
    public int findKthLargest(int[] nums, int k) {
          int low=Integer.MAX_VALUE;
          int high=0;
        for(int i:nums){
            low=Math.min(low,i);
            high=Math.max(high,i);
        }
        int ans=0;
        while(low<=high){
            int m=(low+high)/2;
            if(canGet(nums,m,k)){
                ans=m;
                low=m+1;
            }
            else
                high=m-1;
        }
        return ans;
    }
    boolean canGet(int nums[],int m,int k){
        int count=0;
        for(int i:nums){
            if(i>=m)
                count++;
        }
        return count>=k;
    }
}
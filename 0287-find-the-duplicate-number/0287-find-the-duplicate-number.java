class Solution {
    public int findDuplicate(int[] nums) {
        int low=1;
        int high=nums.length;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(canPossible(nums,mid)){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
       
    }
    boolean canPossible(int nums[],int mid){
        int count=0;
        for(int i:nums){
            if(i<=mid)
                count++;
        }
        return count>mid;
    }
}
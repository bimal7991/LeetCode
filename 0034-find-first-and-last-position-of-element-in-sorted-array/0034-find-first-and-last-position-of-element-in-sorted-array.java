class Solution {
    public int[] searchRange(int[] nums, int target) {
           int i=findlastPosition(nums,target);
           int j=findfastPosition(nums,target);
        return new int[]{j,i};
    }
    int findlastPosition(int nums[],int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target)
                ans=mid;
            if(nums[mid]>target){
                high=mid-1;
                
            }
            else
                low=mid+1;
        }
        return ans;
    }
    int findfastPosition(int nums[],int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
               if(nums[mid]==target)
                ans=mid;
            if(nums[mid]<target){
                low=mid+1;
                
            }
            else
                high=mid-1;
        }
        return ans;
    }
}
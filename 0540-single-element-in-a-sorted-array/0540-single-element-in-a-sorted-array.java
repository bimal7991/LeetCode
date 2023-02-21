class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=1;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(mid%2==1){
                if(nums[mid]==nums[mid-1]){
                    low=mid+1;
                }
                else
                    high=mid-1;
            }
            else{
                if(nums[mid]==nums[mid-1]){
                    high=mid-1;
                }
                else
                    low=mid+1;
            }
        }
        return nums[high];
    }
}
class Solution {
    public int specialArray(int[] nums) {
        
        int low=0;
        int high=1000;
        while(low<=high){
            int mid=(low+high)/2;
            int count=greaterThan(nums,mid);
            if(count==mid)
                return mid;
            else if(count>mid){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
        
    }
   int greaterThan(int nums[],int mid){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=mid)
                count++;
        }
        return count;
    }
}
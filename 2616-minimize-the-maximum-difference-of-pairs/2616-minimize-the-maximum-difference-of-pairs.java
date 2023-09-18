class Solution {
    public int minimizeMax(int[] nums, int p) {
         Arrays.sort(nums);
         int low=0;
         int ans=0;
         int high=nums[nums.length-1]-nums[0];
         while(low<=high){
             int mid=(low+high)/2;
             if(canMakePair(mid,nums,p))
             {
                 ans=mid;
                 high=mid-1;
             }
             else
                 low=mid+1;
         }
        return ans;
    }
    boolean canMakePair(int mid,int nums[],int p){
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]<=mid)
            {
                count++;
                i++;
            }
        }
        return count>=p;
    }
}
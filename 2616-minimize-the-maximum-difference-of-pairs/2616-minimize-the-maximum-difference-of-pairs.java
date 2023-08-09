class Solution {
    public int minimizeMax(int[] nums, int p) {
         Arrays.sort(nums);
        int n=nums.length;
        int low=0;
        int high=nums[n-1]-nums[0];
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(canPair(mid,p,nums)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    boolean canPair(int mid,int p,int nums[]){
        int n=nums.length;
        int k=0;
        for(int i=0;i<n-1;i++){
            if(nums[i+1]-nums[i]<=mid){
                k++;
                i++;
            }
            if(k==p)
                return true;
        }
        return false;
    }
}
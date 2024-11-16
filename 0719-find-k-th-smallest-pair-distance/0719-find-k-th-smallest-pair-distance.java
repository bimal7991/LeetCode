class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n=nums.length;
       Arrays.sort(nums);
       int high=nums[n-1]-nums[0];
        int low=nums[1]-nums[0];
       for(int i=1;i<n;i++){
           low=Math.min(low,nums[i]-nums[i-1]);
       }
        int ans=-1;
    while(low<=high){
        int mid=(low+high)/2;
        if(countPairs(nums,mid)>=k){
            ans=mid;
            high=mid-1;
        }
        else
            low=mid+1;
    }
        return ans;
  }
    int countPairs(int nums[],int mid){
        int n=nums.length;
        int i=0;
        int j=0,count=0;
         while(j<n){
                if(nums[j]-nums[i]>mid){
                    i++;
                }
             else
             {
                 count+=j-i;
                 j++;
             }
                 
        }
        return count;
    }
}
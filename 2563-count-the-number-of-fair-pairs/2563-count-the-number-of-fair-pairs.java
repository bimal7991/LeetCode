class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count1=0;
        long count2=0;
        for(int i=0;i<nums.length;i++){
            int t1=lower-1-nums[i];
            int t2=upper-nums[i];
            int ind1=findIndex(nums,i,t1);
            int ind2=findIndex(nums,i,t2);
            // System.out.println(ind1+" "+ind2);
            count1=count1+ (ind1==-1?0:ind1-i);
            count2=count2+ (ind2==-1?0:ind2-i);
        }
        return count2-count1;
        
    }
    int findIndex(int nums[],int low,int target){
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<=target){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}
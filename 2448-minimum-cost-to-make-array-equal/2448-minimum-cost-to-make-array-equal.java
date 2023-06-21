class Solution {
    public long minCost(int[] nums, int[] cost) {
        long count=0;
        int low=Integer.MAX_VALUE;;
        int high=0;
        for(int i:nums){
            high=Math.max(i,high);
            low=Math.min(i,low);
        }
        
        while((high-low)>2){
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
 
            long cost1 = Cost(nums, cost, mid1);
            long cost2 = Cost(nums, cost, mid2);
            
            if (cost1 < cost2)
                high = mid2;

            else  
                low = mid1;
           
              
        }
        long ans=Long.MAX_VALUE;
        for(int i=low;i<=high;i++){
            ans=Math.min(ans,Cost(nums,cost,i));
        }
      
        
        return ans;
    }
    long Cost(int nums[],int cost[],int mid){
        long sum=0;
        for(int i=0;i<nums.length;i++){
                sum=sum+ Math.abs(mid-nums[i])* (long)cost[i];
            }
        return sum;
    }
}
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        long low=1;
        long high=10000001;
        long ans=0;
        for(int i:weights){
            low=Math.max(low,i);
        }
        while(low<=high){
            long mid=(low+high)/2;
            if(isCapacity(weights,days,mid)){
                high=mid-1;
                ans=mid;
            }
            else
                low=mid+1;
            
        }
        return (int)ans;
    }
    boolean isCapacity(int nums[],int d,long c){
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(sum>c){
                sum=nums[i];
                count++;
            }
        }
        count++;
        if(count<=d)
            return true;
        return false;
            
    }
}
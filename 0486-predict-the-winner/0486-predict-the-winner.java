class Solution {
    int first=0;
    int second=0;
    
    public boolean PredictTheWinner(int[] nums) {
     int ans=helper(nums,0,nums.length-1,true,0);
        
        return ans>=0;
    }
    int helper(int []nums,int low,int high,boolean turn,int sum){
        if(low>high)
        {
             
            return sum;
        }
        
        
        if(turn){
            int start=helper(nums,low+1,high,!turn,sum+nums[low]);
            int end=helper(nums,low,high-1,!turn,sum+nums[high]);
            return Math.max(start,end);
           
        }
        else{
            int start=helper(nums,low+1,high,!turn,sum-nums[low]);
            int end=helper(nums,low,high-1,!turn,sum-nums[high]);
            return Math.min(start,end);
        }
       
    }
}
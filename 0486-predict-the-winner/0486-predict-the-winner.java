class Solution {
    int first=0;
    int second=0;
    
    public boolean PredictTheWinner(int[] nums) {
     return helper(nums,0,nums.length-1,0,0);
        
       
    }
    boolean helper(int []nums,int low,int high,int p1,int p2){
           if(low>high){
               if(p1>=p2)
                   return true;
               else
                   return false;
           }       
         return !helper2(nums,low+1,high,p1+nums[low],p2) || 
              !helper2(nums,low,high-1,p1+nums[high],p2);
    }
    boolean helper2(int nums[],int low,int high,int p1,int p2){
        if(low>high){
               if(p1<p2)
                   return true;
               else
                   return false;
           }   
        return !helper(nums,low+1,high,p1,p2+nums[low]) || 
              !helper(nums,low,high-1,p1,p2+nums[high]);
    }
}
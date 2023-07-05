class Solution {
    public int longestSubarray(int[] nums) {
        int prev=0,curr=0,j=0;
        int res=0;
        while(j<nums.length){
            if(nums[j]==1)
                curr++;
            else{
                res=Math.max(res,curr+prev);
                prev=curr;
                curr=0;
            }
            j++;
        }
         res=Math.max(res,curr+prev);
        if(res==nums.length)
            res--;
        return res;
        
    }
}
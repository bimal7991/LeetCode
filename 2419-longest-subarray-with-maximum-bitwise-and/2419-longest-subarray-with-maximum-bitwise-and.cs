public class Solution {
    public int LongestSubarray(int[] nums) {
        int prev=nums[0];
        int max=nums[0];
        int count=1;
        int ans=1;
        for(int i=1;i<nums.Length;i++){
            if(nums[i]==prev){
                count++;
                if(nums[i]>=max){
                    max=nums[i];
                    ans=Math.Max(ans,count);
                }
            }
            else{
                count=1;
                prev=nums[i];
                if(nums[i]>max){
                  max=nums[i];
                    ans=1;
                }
            }
        }
        return ans;
    }
    
}
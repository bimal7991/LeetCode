class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum=0;
        int i=0;
        int j=0;
        int count=0;
        while(j<nums.length){
             sum=sum+nums[j];
             while(sum>goal && i<j){
                 sum=sum-nums[i];
                 i++;
             }
             if(sum==goal){
                 int k=i;
                 while(k<j && nums[k]==0){
                     k++;
                     count++;
                 }
                 count++;
             }
            j++;
        }
        
            
        return count;
    }
}
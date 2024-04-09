class Solution {
    public int timeRequiredToBuy(int[] nums, int k) {
        int count=0;
        while(nums[k]!=0){
            for(int i=0;i<nums.length;i++){
                
                if(nums[k]==0)
                    return count;
                if(nums[i]!=0){
                    count++;
                    nums[i]=nums[i]-1;
                }
            }
        }
        return count;
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
         long prod=1;
         long mult=1;
         int zero=0;
        for(int i:nums){
            prod=prod*i;
            if(i==0)
            {
                zero++;
                continue;
            }
            mult=mult*i;
        }
        if(zero>1)
            mult=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=(int)mult;
            }else
            nums[i]=(int)(prod/nums[i]);
        }
        return nums;
    }
}
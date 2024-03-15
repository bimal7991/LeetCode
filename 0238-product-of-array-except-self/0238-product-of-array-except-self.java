class Solution {
    public int[] productExceptSelf(int[] nums) {
        int suffix[]=new int[nums.length];
        int m=1;
        for(int i=nums.length-1;i>=0;i--){
            m=m*nums[i];
            suffix[i]=m;
        }
        m=1;
        for(int i=0;i<nums.length;i++)
        {
           int p=nums[i];
           if(i==0) 
           nums[i]=suffix[i+1];
          else if(i==nums.length-1)
               nums[i]=m;
           else
               nums[i]=m*suffix[i+1];
            m=m*p;
        }
        return nums;
    }
}
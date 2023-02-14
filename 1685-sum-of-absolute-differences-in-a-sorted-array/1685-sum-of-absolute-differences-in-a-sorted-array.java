class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int prefix[]=new int[nums.length];
        int n=nums.length;
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                int f=prefix[n-1]-prefix[i];
                ans[i]=f-(n-1-i)*nums[i];
            }
            else if(i==n-1){
               ans[i]=nums[i]*n- prefix[i];
            }
            else 
            {
                int f=prefix[n-1]-prefix[i] - (n-1-i)*nums[i];
                int b=i*nums[i]-prefix[i-1];
                ans[i]=f+b;
            }
        }
        return ans;
    }
}
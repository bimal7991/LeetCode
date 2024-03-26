class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        
        for(int i=0;i<n;i++)
            if(nums[i]<0)
                nums[i]=0;
        
        for(int i=0;i<nums.length;i++){
            int ind=Math.abs(nums[i])-1;
            if(ind>=0 && ind<n  && nums[ind]>=0){
                nums[ind]=nums[ind]*-1;
                if(nums[ind]==0)
                    nums[ind]=-(n+1);
            }
        }
       // System.out.println(Arrays.toString(nums));
        for(int i=0;i<n;i++)
        {
            if(nums[i]>=0)
                return i+1;
        }
        return n+1;
    }
}
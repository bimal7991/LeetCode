class Solution {
    public boolean validPartition(int[] nums) {
        return helper(nums,nums.length-1);
    }
    boolean helper(int[] nums,int i){
        if(i<0)
            return true;
      boolean ans=false;
       if(i-1>=0 && nums[i]==nums[i-1])
          ans=ans || helper(nums,i-2);
        
       if(i-2>=0 && (nums[i]==nums[i-1]+1 && nums[i]==nums[i-2]+2 && nums[i-1]==nums[i-2]+1))
            ans=ans || helper(nums,i-3);
       if(i-2>=0 && (nums[i]==nums[i-1] && nums[i]==nums[i-2]))
            ans=ans || helper(nums,i-3);
        
       if(ans)
          return true;
        else
        return  false;
    }
}
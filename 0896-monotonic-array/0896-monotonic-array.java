class Solution {
    public boolean isMonotonic(int[] nums) {
        if(checkIncreasing(nums) || checkDecreasing(nums))
            return true;
        else
            return false;
    }
   boolean checkIncreasing(int nums[]){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]<nums[i])
                return false;
        }
       return true;
    }
     boolean checkDecreasing(int nums[]){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]>nums[i])
                return false;
        }
       return true;
    }
}
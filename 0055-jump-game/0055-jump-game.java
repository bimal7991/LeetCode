class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1)
            return true;
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max-1,nums[i]);
            if(i+max>=nums.length-1)
                return true;
            if(max==0 && i!=nums.length-1)
                return false;
        }
        return false;
    }
}
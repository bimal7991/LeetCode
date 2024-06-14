class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int i=1;
        int res=0;
        for(i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                res+=nums[i-1]-nums[i]+1;
                nums[i]=nums[i-1]+1;
            }
        }
        return res;
    }
}
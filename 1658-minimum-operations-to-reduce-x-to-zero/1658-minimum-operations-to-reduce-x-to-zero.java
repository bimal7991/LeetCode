class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int i:nums)
            sum=sum+i;
        if(x>sum)
            return -1;
        if(x==sum)
            return nums.length;
        int i=0;
        int j=0;
        int target=sum-x;
        int max=nums.length;
        sum=0;
        while(j<nums.length){
            sum=sum+nums[j];
            if(sum==target){
               max=Math.min( i-0 + (nums.length-j-1),max);
            }
            while(sum>=target){
                sum=sum-nums[i];
                i++;
                if(sum==target){
                 max=Math.min( i-0 + (nums.length-j-1),max);
                }
            }
            j++;
        }
        return max==nums.length?-1:max;
    }
}
class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long prefix[]=new long[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int i=0,j=1;
        long max=-1;
        while(j<nums.length-1){
            if(prefix[j]>nums[j+1])
                max=Math.max(max,prefix[j+1]);
            j++;
        }
        return max;
    }
}
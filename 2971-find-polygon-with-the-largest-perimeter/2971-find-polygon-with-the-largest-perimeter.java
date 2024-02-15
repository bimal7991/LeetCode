class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long prefix[]=new long[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int i=0,j=2;
        long max=-1;
        while(j<nums.length){
            if(i==0){
                if(nums[j]<prefix[j-1]){
                    max=Math.max(max,prefix[j]);
                }
            }
            else if(nums[j]<prefix[j-1]-prefix[i]){
                 max=Math.max(max,prefix[j]-prefix[i]);
            }
            else{
                i++;
            }
            j++;
        }
        return max;
    }
}
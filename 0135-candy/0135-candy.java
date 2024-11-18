class Solution {
    public int candy(int[] nums) {
       int left[]=new int[nums.length];
       int right[]=new int[nums.length];
       Arrays.fill(left,1);
       Arrays.fill(right,1);
       for(int i=1;i<nums.length;i++){
           if(nums[i]>nums[i-1])
               left[i]=left[i-1]+1;
       }
        for(int i=nums.length-2;i>=0;i--){
           if(nums[i]>nums[i+1])
               right[i]=right[i+1]+1;
       }
        // System.out.println(Arrays.toString(left));
        //  System.out.println(Arrays.toString(right));
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.max(left[i],right[i]);
        }
        return sum;
        
    }
}
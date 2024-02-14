class Solution {
    public int[] rearrangeArray(int[] nums) {
        int ans[]=new int[nums.length];
        int i=0,j=0;
        int k=1;
        while(j<nums.length ){
              if(nums[j]>0){
                  ans[i]=nums[j];
                  i=i+2;
              }else{
                  ans[k]=nums[j];
                  k=k+2;
              }
            j++;
        }
        return ans;
    }
}
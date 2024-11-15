class Solution {
    public int maxProduct(int[] nums) {
          int max=1,min=1,res=nums[0];
          for(int i:nums){
              if(i<0)
              {
                  int t=min;
                  min=max;
                  max=t;
              }
              min=Math.min(i,i*min);
              max=Math.max(i,i*max);
              res=Math.max(max,res);
              // System.out.println(min+" "+max);
          }
        return res;
    }
}
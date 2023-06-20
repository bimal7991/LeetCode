class Solution {
    public int[] getAverages(int[] nums, int k) {
        int i=0,j=0;
        long sum=0;
        boolean f=true;
        int ans[]=new int[nums.length];
        Arrays.fill(ans,-1);
        while(j<nums.length-k){
            if(j>=k){
                if(f){
                    for(int m=j;m<=j+k;m++){
                        sum=sum+nums[m];
                    }
                    f=false;
                }
                else
                    sum=sum+nums[j+k];
               ans[j]=(int)(sum/(2*k+1)); 
               sum=sum-nums[i];
               i++;
            }
            else if(j<k){
                sum=sum+nums[j];
            }
            j++;
            
        }
        return ans;
    }
}
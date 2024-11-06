class Solution {
    public int jump(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<=i+nums[i] && j<nums.length;j++){
              dp[j]=Math.min(dp[j],dp[i]+1); 
            }
        }
        // System.out.println(Arrays.toString(dp));
       return dp[nums.length-1];
        // return helper(0,nums);
        
    }
    int helper(int index,int nums[]){
        if(index>=nums.length-1)
            return 0;
        int min=Integer.MAX_VALUE-1;
        for(int i=1;i<=nums[index];i++){
            min=Math.min(1+helper(index+i,nums),min);
        }
        return min;
    }
}
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(p1,p2)->p1[1]-p2[1]);
        int dp[]=new int[pairs.length+1];
        int count=0;
        int start=Integer.MIN_VALUE,end=Integer.MIN_VALUE;
        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]>end){
                end=pairs[i][1];
                start=pairs[i][0];
                count++;
                if(i>0)
                dp[i]=Math.max(dp[i-1]+1,count);
                else
                    dp[i]=1;
            }
            else{
                if(i>=1)
                dp[i]=dp[i-1];
                
            }
            
        }
        return dp[pairs.length-1];
    }
}
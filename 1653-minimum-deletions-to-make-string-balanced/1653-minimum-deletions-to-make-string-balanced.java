class Solution {
    public int minimumDeletions(String s) {
        int[] dp =  new int[s.length()+1];
        int idx =1;
        int bCount=0;
        
        for(int i =0 ;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
            {
             dp[idx] = Math.min(dp[idx-1]+1,bCount);   
            }
            else
            {
                dp[idx]=dp[idx-1];
                bCount++;
            }
            
            idx++;
        }
        return dp[s.length()];
    }
}
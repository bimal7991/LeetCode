class Solution {
    
    public int minimumSubstringsInPartition(String s) {
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(0,s,dp); 
    }
    int helper(int i,String s,int dp[]){
        if(i>=s.length())
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int arr[]=new int[26];
        int ans=s.length();
        for(int j=i;j<s.length();j++){
            arr[s.charAt(j)-'a']++;
            int min=100001;
            int max=-1;
            for(int k:arr){
                if(k>0){
                    min=Math.min(min,k);
                    max=Math.max(max,k);
                }
            }
            if(min==max){
               ans=Math.min(ans,1+helper(j+1,s,dp)); 
            }
        }
        return dp[i]=ans;
    }
}
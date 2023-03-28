class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i:days)
            hs.add(i);
        
        int day=days[days.length-1];
        int dp[]=new int[day+1];
        for(int d=1;d<=day;d++){
            
           if(!hs.contains(d)){
               dp[d]=dp[d-1];
              
               continue;
           }
            
            
                dp[d]=costs[0]+dp[d-1];
           
                dp[d]=Math.min(dp[d],dp[Math.max(d-7,0)]+costs[1]);
           
                dp[d]=Math.min(costs[2]+dp[Math.max(d-30,0)], dp[d]);
            
            
        }
        return dp[day];
    }
}
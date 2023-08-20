class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
         int dp[]=new int[offers.size()];
          Collections.sort(offers,(a,b)->a.get(1)-b.get(1));
          
        for(int i=0;i<offers.size();i++){
            int prev=getPrev(offers,offers.get(i).get(0));
            dp[i]=Math.max(dp[i], prev!=-1 ?dp[prev]+offers.get(i).get(2):offers.get(i).get(2));
            if(i>=1)
            dp[i]=Math.max(dp[i-1],dp[i]);
        }
        

        return dp[offers.size()-1];
    }
    int getPrev( List<List<Integer>> offers,int val){
        int index=-1;
        int low=0;
        int high=offers.size()-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(offers.get(mid).get(1)<val){
                index=mid;
                low=mid+1;
                
            }else{
                high=mid-1;
            }
        }
        return index;
    }
}
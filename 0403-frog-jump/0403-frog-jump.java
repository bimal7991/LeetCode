class Solution {
    public boolean canCross(int[] stones) {
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        int dp[][]=new int[stones.length][stones.length];
        for(int i=0;i<stones.length;i++){
            hm.put(stones[i],i);
        }
        return helper(stones,0,0,hm,dp);
    }
    boolean helper(int stones[],int k,int jump,HashMap<Integer,Integer> hm,int dp[][]){
        int index=hm.getOrDefault(jump,-1);
        if(index==-1)
            return false;
        if(index==stones.length-1)
            return true;
        if(dp[index][k]==1)
            return true;
        if(dp[index][k]==2)
            return false;
        
        boolean ans=false;
        
        if(k==0){
            ans=ans || helper(stones,k+1,jump+k+1,hm,dp);
        }
        else if(k==1){
            ans=ans || helper(stones,k,jump+k,hm,dp) || helper(stones,k+1,jump+k+1,hm,dp);
        }
        else{
            ans=ans || helper(stones,k,jump+k,hm,dp) || helper(stones,k+1,jump+k+1,hm,dp) || helper(stones,k-1,jump+k-1,hm,dp);
        }
        dp[index][k]= ( ans ) ? 1:2;
        return ans;
    }
}
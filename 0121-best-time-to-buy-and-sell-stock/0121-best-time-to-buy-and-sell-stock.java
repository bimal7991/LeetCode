class Solution {
    
    public int maxProfit(int[] prices) {
        int maxP=0;
        int minB=prices[0];
        for(int i=1;i<prices.length;i++){
            maxP=Math.max(maxP,prices[i]-minB);
            minB=Math.min(minB,prices[i]);
        }
        return maxP;
    }
}
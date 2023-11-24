class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int j=piles.length-2;
        int i=0;
        int sum=0;
        while(i<j){
            sum=sum+piles[j];
            j=j-2;
            i++;
        }
        return sum;
        
    }
}
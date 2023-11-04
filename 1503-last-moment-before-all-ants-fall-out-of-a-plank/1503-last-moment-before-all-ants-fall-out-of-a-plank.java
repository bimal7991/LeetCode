class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        
        int max=0;
        for(int k:left){
            max=Math.max(max,k);
        }
         for(int k:right){
            max=Math.max(max,n-k);
        }
        return max;
    }
}
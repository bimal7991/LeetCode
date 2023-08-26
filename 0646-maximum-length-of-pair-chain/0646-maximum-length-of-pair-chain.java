class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(p1,p2)->p1[1]-p2[1]);
        int dp[]=new int[pairs.length+1];
        int count=0;
        int start=Integer.MIN_VALUE,end=Integer.MIN_VALUE;
        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]>end){
                end=pairs[i][1];
                count++;
                
            }
            
        }
        return count;
    }
}
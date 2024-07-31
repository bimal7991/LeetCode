class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int dp[][]=new int[books.length][shelfWidth+1];
        for(int d[]:dp)
            Arrays.fill(d,-1);
        return helper(0,books,0,shelfWidth,0,dp);
    }
    int helper(int i,int books[][],int w,int shelfWidth,int h,int dp[][]){
        if(i==books.length)
            return h;
        if(dp[i][w]!=-1)
            return dp[i][w];
        int inc=Integer.MAX_VALUE;
        int ex=Integer.MAX_VALUE;
        if(w+books[i][0]<=shelfWidth){
            inc=helper(i+1,books,w+books[i][0],shelfWidth,Math.max(h,books[i][1]),dp);
        }
        ex=h+helper(i+1,books,books[i][0],shelfWidth,books[i][1],dp);
        return dp[i][w]=Math.min(inc,ex);
    }
}
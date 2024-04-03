class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0) && dfs(board,word,0,i,j,vis))
                    return true;
            }
        }
        return false;
    }
    boolean dfs(char [][]board,String word,int ind,int i,int j,int vis[][]){
        if(ind==word.length())
            return true;
        int n=board.length;
        int m=board[0].length;
        if(i>=n || j>=m || i<0 || j<0 || board[i][j]!=word.charAt(ind) || vis[i][j]==1)
            return false;
        vis[i][j]=1;
        boolean res=dfs(board,word,ind+1,i+1,j,vis) || dfs(board,word,ind+1,i-1,j,vis) || 
            dfs(board,word,ind+1,i,j+1,vis) || dfs(board,word,ind+1,i,j-1,vis);
        vis[i][j]=0;
        return res;
    }
    
}
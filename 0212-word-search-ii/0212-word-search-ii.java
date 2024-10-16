class Solution {
    int dir[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public List<String> findWords(char[][] board, String[] words) {
        Trie root=insertWords(words);
        List<String> ans=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='*'){
                    dfs(board,i,j,ans,root);
                }
            }
        }
        return ans;
    }
    public void dfs(char board[][],int i,int j,List<String> ans,Trie root){
        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j]=='*')
            return;
        char c=board[i][j];
        if(!root.containsKey(c))
            return;
        root=root.get(c);
        if(root.word!=null){
            ans.add(root.word);
            root.word=null;
        }
        board[i][j]='*';
        for(int d[]:dir){
            int row=d[0]+i;
            int col=d[1]+j;
            dfs(board,row,col,ans,root);
        }
         board[i][j]=c;
    }
    
    public Trie insertWords(String words[]){
        Trie root=new Trie();
        for(String s:words){
            Trie node=root;
            for(char c:s.toCharArray()){
                if(!node.containsKey(c))
                    node.put(c);
                node=node.get(c);
            }
            node.setWord(s);
        }
        return root;
    }
}



class Trie {
    Trie next[]=new Trie[26];
    String word;
    public boolean containsKey(char c){
        return next[c-'a']!=null;
    }
    public Trie get(char c){
        return next[c-'a'];
    }
    public void put(char c){
        next[c-'a']=new Trie();
    }
    public void setWord(String s){
        word=s;
    }
}
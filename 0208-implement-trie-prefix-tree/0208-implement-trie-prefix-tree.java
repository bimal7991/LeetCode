class Trie {
    TreeNode root;
    public Trie() {
       root=new TreeNode();
    }
    
    public void insert(String word) {
         TreeNode temp=root;
        for(char c:word.toCharArray()){
            if(!temp.containsKey(c)){
                temp.put(c,new TreeNode());
            }
            temp=temp.get(c);
        }
        temp.setEnd();
    }
    
    public boolean search(String word) {
         TreeNode temp=root;
        for(char c:word.toCharArray()){
            if(!temp.containsKey(c)){
                return false;
            }
            temp=temp.get(c);
        }
       return temp.isEnd();
    }
    
    public boolean startsWith(String word) {
        TreeNode temp=root;
        for(char c:word.toCharArray()){
            if(!temp.containsKey(c)){
                return false;
            }
            temp=temp.get(c);
        }
        return true;
    }
}
class TreeNode {
    TreeNode node[]=new TreeNode[26];
    boolean flag=false;
    
    void put(char c,TreeNode t){
        node[c-'a']=t;
    }
    TreeNode get(char c){
        return node[c-'a'];
    }
    boolean containsKey(char c){
        return node[c-'a']!=null;
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
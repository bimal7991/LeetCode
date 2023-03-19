class WordDictionary {
    TreeNode root;
    char ch[]=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public WordDictionary() {
        root=new TreeNode();
    }
    
    public void addWord(String word) {
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
        return helper(word,temp);
        
    }
    public boolean helper(String word,TreeNode temp){
        for(int i=0;i<word.length();i++ ){
            char c=word.charAt(i);
            if(c=='.'){
                boolean f=false;
               for(char a:ch){
                   if(temp.containsKey(a) && helper(word.substring(i+1),temp.get(a))){
                       return true;
                   }
               }
                return false; 
            }
                
            if(c!='.' && !temp.containsKey(c)){
                return false;
            }
            
            temp=temp.get(c);
        }
       return temp.isEnd();
    }
    
}
class TreeNode{
    TreeNode next[]=new TreeNode[26];
    boolean flag=false;
    
    boolean containsKey(char c){
        return next[c-'a']!=null;
    }
    TreeNode get(char c){
        return next[c-'a'];
    }
    void put(char c, TreeNode t){
        next[c-'a']=t;
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
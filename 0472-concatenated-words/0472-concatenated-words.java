class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
       List<String> ans=new ArrayList<String>();
        Trie trie=new Trie();
        for(String w:words){
             if (w.length() == 0) {
                continue;
            }
            trie.insert(w);
        }
        
        for(String w:words){
            if (w.length() == 0) {
                continue;
            }
            if(trie.isConcat(w.toCharArray(),0,0)){
                 ans.add(w);
               // System.out.println(w);
            }
               
        }
        return ans;
        
    }
}
class Trie{
    TreeNode root;
    Trie(){
        root=new TreeNode();
    }
    public void insert(String word){
        TreeNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new TreeNode());
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();
        //System.out.println(node.isEnd());
    }
    public boolean isConcat(char arr[],int index,int count){
        TreeNode node=root;
        for(int i=index;i<arr.length;i++){
            if(!node.containsKey(arr[i])){
                return false;
            }
            if(node.get(arr[i]).isEnd()){
               //System.out.println(i);
                if(i==arr.length-1){
                    return count>=1;
                }
                if(isConcat(arr,i+1,count+1))
                       return true;
                
            }
            node=node.get(arr[i]);
        }
        return false;
    }
    
}
class TreeNode{
    TreeNode next[]=new TreeNode[26];
    boolean flag=false;
    boolean containsKey(char c){
        return (next[c-'a']!=null);
    }
    void put(char c,TreeNode node){
        next[c-'a']=node;
    }
    public TreeNode get(char c) {
        return  next[c-'a'];
    }
    void  setEnd(){
        flag=true;
    }
    boolean isEnd() {
        return flag;
    }   
}
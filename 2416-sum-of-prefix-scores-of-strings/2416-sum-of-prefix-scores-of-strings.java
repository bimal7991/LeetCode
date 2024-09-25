class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie t=new Trie();
        for(String w:words){
            t.insert(w);
        }
        int ans[]=new int[words.length];
        for(int i=0;i<words.length;i++){
            ans[i]=t.getPrefixCount(words[i]);
        }
        return ans;
    }
}
class  TreeNode{
    TreeNode next[]=new TreeNode[26];
    boolean flag=false;
    int count=0;
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
    void increaseCount(){
        count++;
    }
    int getCount(){
        return count;
    }
}
public class Trie {
    public static TreeNode root;
    Trie(){
        root=new TreeNode();
    }
    public static void insert(String word){
        TreeNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new TreeNode());
            }
            node=node.get(word.charAt(i));
            node.increaseCount();
        }
        node.setEnd();
    }
    public static int getPrefixCount(String word){
        TreeNode node=root;
        int count=0;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return count;
            }
            node=node.get(word.charAt(i));
            count+=node.getCount();
        }
        return count;
    }
}
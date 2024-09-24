class Solution {
    int res=0;
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
       Trie t=new Trie();
        for(int a:arr1){
            t.insert(Integer.toString(a));
        }
        int min=0;
        for(int a:arr2){
            int count=t.search(Integer.toString(a));
            min=Math.max(count,min);
        }
        return min;
        
    }
}

class  TreeNode{
    TreeNode next[]=new TreeNode[100];
    boolean flag=false;
    boolean containsKey(char c){
        return (next[c-'0']!=null);
    }
    void put(char c,TreeNode node){
        next[c-'0']=node;
    }
    public TreeNode get(char c) {
        return  next[c-'0'];
    }
    void  setEnd(){
        flag=true;
    }
    boolean isEnd() {
        return flag;
    }
}
class Trie {
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
        }
        node.setEnd();
    }
    public static int search(String word){
        TreeNode node=root;
        int count=0;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return count;
            }
            node=node.get(word.charAt(i));
            count++;
        }
        return count;
    }
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String longestString(int n, String[] arr) {
        // code here
        Trie t=new Trie();
        String ans="";
        for(String w:arr)
         {
           t.insert(w);   
         }
         for(String w:arr){
             if(t.isPresent(w)){
                 if(w.length()>ans.length()){
                     ans=w;
                 }
                 else if(w.length()==ans.length()){
                     if(w.compareTo(ans)<0)
                       ans=w;
                 }
                 
             }
         }
         return ans;
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
        }
        node.setEnd();
    }
    public static boolean search(String word){
        TreeNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return  false;
            }
            node=node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    public static boolean isPresent(String word){
         for(int i=1;i<=word.length();i++){
             if(!search(word.substring(0,i)))
               return false;
               
         }
        
        return  true;
    }
}
    
    
    
        
class  TreeNode{
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
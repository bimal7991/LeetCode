class Solution {
    int parent[]=new int[26];
    char ch[]=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public String smallestEquivalentString(String s1, String s2, String base) {
        for(int i=0;i<26;i++)
            parent[i]=i;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                union(s1.charAt(i)-'a',s2.charAt(i)-'a');
            }            
        }
        char arr[]=base.toCharArray();
        for(int i=0;i<base.length();i++){
            int a=find(arr[i]-'a');
            arr[i]=ch[a];
        }
        return new String(arr);
        
        
        
    }
    int find(int a){
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
    void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a>b){
            parent[a]=b;
        }
        else
            parent[b]=a;
    }
}
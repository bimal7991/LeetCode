class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs=new HashSet<>();
        for(String p:wordDict){
            hs.add(p);
        }
        List<String> ans=new ArrayList<>();
        helper(s,0,0,ans,new ArrayList<String>(),hs);
        return ans;
    }
  void helper(String s,int i,int j,List<String> ans,List<String> sub,HashSet<String> hs){
      
      if(j>=s.length()){
        if(sub.size()==0)
            return;
          String p= String.join(" ", sub);
          // System.out.println(p.length()+" "+sub.size()+" "+s.length());
          if(p.length()-sub.size()+1==s.length())
          ans.add(p);
          return;
      }
      
        if(hs.contains(s.substring(i,j+1))){
            sub.add(s.substring(i,j+1));
            helper(s,j+1,j+1,ans,sub,hs);
            sub.remove(sub.size()-1);
        }
        helper(s,i,j+1,ans,sub,hs);
        
         
    }
}
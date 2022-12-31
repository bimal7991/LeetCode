class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict=new HashSet<String>(wordDict);
        List<String> temp=new ArrayList<>();
        List<String> res=new ArrayList<>();
        helper(s,dict,0,temp,res);
        return res;
    }
    
    void helper(String s, HashSet<String> dict,int index,List<String> temp,List<String> res){
        if(index==s.length())
        {
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<temp.size()-1;i++){
                sb.append(temp.get(i)+" ");
            }
            sb.append(temp.get(temp.size()-1));
            res.add(sb.toString());
            //System.out.println(res);
            return;
        }        
        
        
        for(int i=index;i<s.length();i++){
            String str=s.substring(index,i+1);
            if(!dict.contains(str))
                continue;
            temp.add(str);
            helper(s,dict,i+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }
    
}
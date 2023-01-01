class Solution {
    public boolean wordPattern(String p, String s) {
         HashMap<Character, String> hm=new HashMap<>();
        HashSet<String> set=new HashSet<>();
         String word[]=s.split(" ");
        if(p.length()!=word.length)
            return false;
        for(int i=0;i<p.length();i++){
            char c=p.charAt(i);
            if(hm.containsKey(c)){
                if(!hm.get(c).equals(word[i]))
                    return false;
            }
            else{
                if(hm.containsValue(word[i]))
                    return false;
                hm.put(c,word[i]);
                
            }
        } 
        return true;
        
    }
}
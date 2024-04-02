class Solution {
    public boolean isIsomorphic(String s, String t) {
         HashMap<Character,Character> hm=new HashMap<>();
          for(int i=0;i<s.length();i++){
              char c=s.charAt(i);
              if(hm.containsKey(c)){
                 if(hm.get(c)!=t.charAt(i))
                      return false;
              }
              else
              {
                  for(char d:hm.values()){
                      if(d==t.charAt(i))
                          return false;
                   }
                  hm.put(c,t.charAt(i));
              }
          }
        return true;
    }
}
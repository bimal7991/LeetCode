class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char c:s1.toCharArray())
            hm.put(c,hm.getOrDefault(c,0)+1);
        int i=0,j=0;
        int count=hm.size();
        while(j<s2.length()){
            char c=s2.charAt(j);
            if(hm.containsKey(c)){
              hm.put(c,hm.getOrDefault(c,0)-1);
              if(hm.get(c)==0)
                count--;
              
            }
             while(count==0){
                  if(j-i+1==s1.length())
                      return true;
                    if(hm.containsKey(s2.charAt(i))){
                           hm.put(s2.charAt(i),hm.getOrDefault(s2.charAt(i),0)+1);
                           if(hm.get(s2.charAt(i))>0)
                               count++;
                    }
                    i++;
           }
              
             
            // while(map.getOrDefault(c,0)>hm.getOrDefault(c,0)){
            //     map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
            //     if(map.get(s2.charAt(i))==0)
            //         map.remove(s2.charAt(i));
            //      i++;
            // }
            // if(hm.equals(map))
            //     return true;
            j++;
        }
        return false;
    }
}
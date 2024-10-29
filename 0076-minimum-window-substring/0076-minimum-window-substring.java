class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hm=new HashMap<>();
        HashMap<Character,Integer> sub=new HashMap<>();
        for(char c:t.toCharArray())
            hm.put(c,hm.getOrDefault(c,0)+1);
        int j=0,i=0;
        int max=s.length()+1;
        int count=0;
        String ans="";
        while(j<s.length()){
             char c=s.charAt(j);
            if(hm.containsKey(c)){
                sub.put(c,sub.getOrDefault(c,0)+1);
            }
            while(checkequals(hm,sub)){
                if(j-i+1<max){
                    max=Math.min(max,j-i+1);
                    ans=s.substring(i,j+1);
                }
                if(sub.containsKey(s.charAt(i))){
                     sub.put(s.charAt(i),sub.get(s.charAt(i))-1);
                }
                i++;
            }
            j++;
            
        }
        return ans;
    }
    public boolean checkequals(HashMap<Character,Integer> hm1,HashMap<Character,Integer> hm2){
        for(char key:hm1.keySet()){
            if(hm2.getOrDefault(key,0)<hm1.get(key))
                return false;
        }
        return true;
    }
}
class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char c:t.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for(char c:s.toCharArray()){
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)==0)
                    hm.remove(c);
            }
            
        }
        for(char c:hm.keySet()){
            return c;
        }
        return 'a';
    }
}
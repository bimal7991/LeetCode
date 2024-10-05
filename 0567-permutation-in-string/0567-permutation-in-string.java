class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char c:s1.toCharArray())
            hm.put(c,hm.getOrDefault(c,0)+1);
        int i=0,j=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<s2.length()){
            char c=s2.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.getOrDefault(c,0)>hm.getOrDefault(c,0)){
                map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
                if(map.get(s2.charAt(i))==0)
                    map.remove(s2.charAt(i));
                 i++;
            }
            if(hm.equals(map))
                return true;
            j++;
        }
        return false;
    }
    boolean checkEquals(HashMap<Character,Integer> hm1,HashMap<Character,Integer> hm2){
        for(char k:hm1.keySet()){
            if(!hm2.containsKey(k))
                return false;
            if(hm1.get(k)>hm2.get(k))
                return false;
        }
        return true;
    }
}
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hm=new LinkedHashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        //System.out.println(hm);
        
        for(int i=0;i<s.length();i++){
            if(hm.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int max=-1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(hm.containsKey(c)){
                max=Math.max(i-hm.get(c)-1,max);
            }
            else
                hm.put(c,i);
        }
        return max;
        
    }
}
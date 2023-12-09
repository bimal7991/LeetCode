class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int j=0,i=0;
        int max=0;
        int repeat=0;
        while(j<s.length()){
            char c=s.charAt(j);
            hm.put(c,hm.getOrDefault(c,0)+1);
            repeat=Math.max(repeat,hm.get(c));
            if(j-i+1-repeat<=k){
                 max=Math.max(max,j-i+1);
            }
            else
            {
                while(j-i+1-repeat>k){
                    c=s.charAt(i);
                    hm.put(c,hm.getOrDefault(c,0)-1); 
                    repeat=Math.max(repeat,hm.get(c));
                    i++;
                }
                if(j-i+1-repeat<=k){
                 max=Math.max(max,j-i+1);
                }
            }
            j++;
        }
        return max;
    }
}
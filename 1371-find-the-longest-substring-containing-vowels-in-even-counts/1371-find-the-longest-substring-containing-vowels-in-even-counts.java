class Solution {
    public int findTheLongestSubstring(String s) {
        int bitmask=0;
        int max=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='a' || c=='e' || c=='o' || c=='i' || c=='u')
              bitmask=bitmask^(1<<(c-'a'));
            if(!hm.containsKey(bitmask))    
                hm.put(bitmask,i);
            max=Math.max(max,i-hm.getOrDefault(bitmask,0));

        }
        return max;
    }
}
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char c:s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        int max=0;
        int count=0;
        for(int v:hm.values()){
            if(v%2==0)
                count+=v;
            else
            {
                count+=v-1;
                max=1;
            }
        }
        if(max==1)
            count++;
        return count;
    }
}
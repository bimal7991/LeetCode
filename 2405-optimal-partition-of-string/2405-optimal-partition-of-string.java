class Solution {
    public int partitionString(String s) {
        HashSet<Character> hs=new HashSet<>();
        int count=0;
        for(char c:s.toCharArray()){
            if(hs.contains(c)){
                hs=new HashSet<>();
                hs.add(c);
                count++;
                
            }else{
                hs.add(c);
            }
        }
        return count+1;
    }
}
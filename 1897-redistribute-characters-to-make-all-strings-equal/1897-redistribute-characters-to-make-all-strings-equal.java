class Solution {
    public boolean makeEqual(String[] words) {
        int n=words.length;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(String w:words){
            for(char c:w.toCharArray()){
                hm.put(c,hm.getOrDefault(c,0)+1);
            }
        }
        for(int v:hm.values()){
            if(v%n!=0)
                return false;
        }
        return true;
    }
}
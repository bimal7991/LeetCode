class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char c:s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        String ans="";
        for(char c:order.toCharArray()){
            if(hm.containsKey(c)){
                int f=hm.get(c);
                while(f>0){
                    ans=ans+c;
                    f--;
                }
                hm.remove(c);
            }
        }
        for(char c:hm.keySet()){
              int f=hm.get(c);
                while(f>0){
                    ans=ans+c;
                    f--;
                }
        }
        return ans;
        
    }
}
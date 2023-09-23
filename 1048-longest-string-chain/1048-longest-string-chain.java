class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        HashMap<String,Integer> hm=new HashMap<>();
        for(String w:words){
            hm.put(w,hm.getOrDefault(w,0)+1);
        }
        int ans=0;
        for(String w:words){
            int max=0;
            for(int i=0;i<w.length();i++){
                String key=w.substring(0,i)+w.substring(i+1,w.length());
                max=Math.max(max,hm.getOrDefault(key,0));
            }
            hm.put(w,max+1);
            ans=Math.max(ans,max+1);
        }
        return ans;
        
        
        
    }
}
class Solution {
    public int totalFruit(int[] fruits) {
       HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
       int i=0;
       int j=0;
       int n=fruits.length;
        int ans=0;
        
        
        while(j<n){
            hs.put(fruits[j],hs.getOrDefault(fruits[j],0)+1);
            if(hs.size()<=2){
                ans=Math.max(ans,(j-i+1));
            }else{
                while(hs.size()>2){
                    hs.put(fruits[i],hs.get(fruits[i])-1);
                    if(hs.get(fruits[i])==0)
                        hs.remove(fruits[i]);
                    i++;
                }
                ans=Math.max(ans,(j-i+1));
            }
            j++;
        }
        return ans;
    }
}
class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:tasks){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int ans=0;
        for(int k:hm.keySet()){
            int v=hm.get(k);
            if(v<2)
                return -1;
            
            if(v%3==0)
                ans=ans+v/3;
            else if(v%3==1){
                ans=ans+(v/3)+1;
            }
            else{
                ans=ans+(v/3)+1;
            }
        }
        return ans;
    }
}
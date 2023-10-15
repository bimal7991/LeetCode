class Solution {
    int mod=1000000007;
    public int numWays(int steps, int arrLen) {
        HashMap<String,Integer> hm=new HashMap<>();
        
       return recursion(0,arrLen,steps,hm);
        
    }
    int recursion(int i,int n,int steps,HashMap<String,Integer> hm){  
        if(steps==0 && i==0)
        {
            return 1;
        }
        if(steps<0)
            return 0;
        String key=""+i+"*"+steps;
        if(hm.containsKey(key))
            return hm.get(key);
        int count=0;
        if(i+1<n)
           count=(count+recursion(i+1,n,steps-1,hm))%mod;
        if(i-1>=0)
            count=(count+recursion(i-1,n,steps-1,hm))%mod;
          count=(count+recursion(i,n,steps-1,hm))%mod;
        hm.put(key,count);
        return count;
         
    }
}
class Solution {
    public int countHomogenous(String s) {
        char prev=s.charAt(0);
        int mod=1000000007;
        long count=1;
        long sum=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==prev)
                count++;
            else{
                sum=(sum+(count*(count+1)/2)%mod)%mod;
                count=1;
                prev=s.charAt(i);
            }
        }
        sum=(sum+(count*(count+1)/2)%mod)%mod;
        return (int)sum;
        
    }
}
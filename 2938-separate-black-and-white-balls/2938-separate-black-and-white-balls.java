class Solution {
    public long minimumSteps(String s) {
         long ans=0;
        int count=0;
        int len=s.length();
        for(int i=len-1;i>=0;i--)
        {
            char c=s.charAt(i);
            if(c=='1')
            {
                ans+=(long)(len-count-1-i);
                count++;
            }
        }
        return ans;
    }
}
class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int i=0,j=0;
        int fcount=0,tcount=0;
        int ans=0;
        while(j<s.length()){
            if(s.charAt(j)=='T')
                tcount++;
            else
                fcount++;
            if(Math.min(tcount,fcount)<=k){
                ans=Math.max(ans,(j-i+1));
            }
            while(i<=j && Math.min(tcount,fcount)>k){
                if(s.charAt(i)=='T')
                tcount--;
            else
                fcount--;
                i++;
                
                if(Math.min(tcount,fcount)<=k){
                ans=Math.max(ans,(j-i+1));
               }
            }
            j++;
        }
        return ans;
    }
}
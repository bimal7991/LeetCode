class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        int p=0;
        int s=0;
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y')
                p++;
            else
                s++;
            prefix[i]=p;
            suffix[i]=s;
        }
        int ans=0;
        int pen=Integer.MAX_VALUE;
        for(int i=0;i<=n;i++){
            int currPen=i>0 ? prefix[n-1]-prefix[i-1] + suffix[i-1] : prefix[n-1];
            if(currPen<pen){
                pen=currPen;
                ans=i;
            }
                
        }
        return ans;
    }
}
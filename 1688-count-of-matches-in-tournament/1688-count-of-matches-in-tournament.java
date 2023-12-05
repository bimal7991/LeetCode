class Solution {
    public int numberOfMatches(int n) {
        int sum=0;
        while(n>1){
            sum=sum+(n/2);
            n=n%2==0?n/2:(n+1)/2;
        }
        return sum;
    }
}
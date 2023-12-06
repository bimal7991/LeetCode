class Solution {
    public int totalMoney(int n) {
        int s=28;
        int rem=n/7;
        int p=7;
        int sum=0;
        if(rem>0)
        sum=sum+ (s*rem)+(p*(rem-1)*rem/2);
        n=n%7;
        while(n>0){
            rem++;
            sum=sum+rem;
            n=n-1;
        }
        return sum;
    }
}
class Solution {
    public int totalMoney(int n) {
        int s=28;
        int rem=n/7;
        int p=0;
        int sum=0;
        while(n>=7){
            sum=sum+s+p;
            p=p+7;
            n=n-7;
        }
        
        while(n>0){
            sum=sum+ (++rem);
            n--;
        }
        return sum;
    }
}
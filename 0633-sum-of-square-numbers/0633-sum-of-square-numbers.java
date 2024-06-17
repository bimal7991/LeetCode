class Solution {
    public boolean judgeSquareSum(int c) {
        int l=0;
        int r=(int)Math.sqrt(c);
        while(l<=r){
            long a=(long)l*l+(long)r*r;
            if(a==c)
                return true;
            else if(a>c){
                r--;
            }else
                l++;
        }
        return false;
    }
}
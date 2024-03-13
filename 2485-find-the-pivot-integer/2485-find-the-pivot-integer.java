class Solution {
    public int pivotInteger(int n) {
        int sum=(n*(n+1))/2;
        int s=(int)Math.sqrt(sum);
        return s*s==sum?s:-1;
    }
}
class Solution {
    public int pivotInteger(int n) {
      return (int)Math.sqrt((n*(n+1))/2)*(int)Math.sqrt((n*(n+1))/2)==(n*(n+1))/2?   (int)Math.sqrt((n*(n+1))/2):-1;
    }
}
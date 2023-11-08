class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int max=0;
        max=Math.max(max,Math.abs(fx-sx));
        max=Math.max(max,Math.abs(fy-sy));
        if(max==0 && t==1)
            return false;
        return max<=t;
    }
}
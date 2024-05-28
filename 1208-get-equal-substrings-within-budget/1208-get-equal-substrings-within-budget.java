class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost=0, i=0,j=0;
        int maxL=0;
        while(j<s.length()){
            cost=cost+Math.abs(t.charAt(j)-s.charAt(j));
            while(cost>maxCost){
                 cost=cost-Math.abs(t.charAt(i)-s.charAt(i));
                i++;
            }
            maxL=Math.max(maxL,j-i+1);
            j++;
        }
        return maxL;
        
    }
}
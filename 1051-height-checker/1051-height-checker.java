class Solution {
    public int heightChecker(int[] heights) {
        int h[]=heights.clone();
        Arrays.sort(h);
        int count=0;
        for(int i=0;i<h.length;i++){
            if(h[i]!=heights[i])
                count++;
        }
        return count;
    }
}
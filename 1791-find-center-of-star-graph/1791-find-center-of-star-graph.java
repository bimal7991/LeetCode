class Solution {
    public int findCenter(int[][] edges) {
        int ind[]=new int[edges.length+2];
        for(int e[]:edges){
            ind[e[0]]++;
            ind[e[1]]++;
            if(ind[e[0]]==edges.length)
                return e[0];
            if(ind[e[1]]==edges.length)
                return e[1];
        }
        return -1;
    }
}
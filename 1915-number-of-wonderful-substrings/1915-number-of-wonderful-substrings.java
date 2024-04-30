class Solution {
    public long wonderfulSubstrings(String word) {
        long res=0;
        int mask=0;
        int prefix[]=new int[1024];
        prefix[0]=1;
        for(char c:word.toCharArray()){
            mask=mask^(1<<(c-'a'));
            res=res+prefix[mask];
            for(int i=0;i<10;i++){
                int p=mask^(1<<i);
                res=res+prefix[p];
            }
            prefix[mask]++;
        }
        return res;
    }
}
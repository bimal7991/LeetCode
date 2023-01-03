class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();
        int count=0;
        for(int i=0;i<m;i++){
            int v=0;
            for(int j=0;j<n;j++){
                int p=strs[j].charAt(i)-'a';
                if(p>=v){
                    v=p;    
                }
                else{
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
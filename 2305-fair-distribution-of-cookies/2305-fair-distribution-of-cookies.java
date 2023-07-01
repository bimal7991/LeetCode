class Solution {
    int res=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        backTrack(cookies,0,new int[k]);
        return res;
    }
    public void backTrack(int cookies[],int index,int child[]){
        
        if(index==cookies.length){
            int max=0;
            for(int c:child){
                max=Math.max(max,c);
            }
            res=Math.min(res,max);
            return;
        }
        
        for(int i=0;i<child.length;i++){
            child[i]+=cookies[index];
            backTrack(cookies,index+1,child);
            child[i]-=cookies[index];
        }
    }
}
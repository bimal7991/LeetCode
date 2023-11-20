class Solution {
    public int garbageCollection(String[] gar, int[] t) {
        int g=-1,p=-1,m=-1;
        int n=gar.length;
        int sum=0;
        for(int i=n-1;i>=0;i--){
            if(g==-1 && gar[i].contains("G")){
                g=i;
            }
            if(p==-1 && gar[i].contains("P")){
                p=i;
            }
            if(m==-1 && gar[i].contains("M")){
                m=i;
            }
            sum=sum+gar[i].length();
        }
        
        for(int i=0;i<g;i++){
            sum=sum+t[i];
        }
         for(int i=0;i<p;i++){
            sum=sum+t[i];
        }
        for(int i=0;i<m;i++){
            sum=sum+t[i];
        }
        return sum;
    }
}
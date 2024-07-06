class Solution {
    public int passThePillow(int n, int time) {
        int mod=time%(2*(n-1));
        if(mod>(n-1))
            return (2*(n-1)-mod+1);
        return mod+1;
        
            
    }
}
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i:nums){
            xor=xor^i;
        }
        int rsbm=xor & -xor;
        int x=0;
        int y=0;
        for(int i:nums){
            if((i & rsbm)==0){
                x=x^i;
            }
            else{
                y=y^i;
            }
        }
        return new int[]{x,y};
        
    }
}
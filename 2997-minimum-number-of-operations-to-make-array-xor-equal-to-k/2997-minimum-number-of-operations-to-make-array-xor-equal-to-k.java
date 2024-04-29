class Solution {
    public int minOperations(int[] nums, int k) {
        int x=0;
        int count=0;
        for(int i:nums){
            x=x^i;
        }
        for(int i=0;i<32;i++){
            int bitX= (1<<i) & x;
            int bitY= (1<<i) & k;
            if(bitX!=0 && bitY==0 || bitX==0 && bitY!=0)
                count++;
        }
        return count;
        
    }
}
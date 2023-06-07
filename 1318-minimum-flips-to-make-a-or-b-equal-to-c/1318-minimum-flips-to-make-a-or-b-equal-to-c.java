class Solution {
    public int minFlips(int a, int b, int c) {
        int count=0;
         while (a> 0 || b>0 || c>0) {
             int a_bit= a & 1;
             int b_bit= b & 1;
             int c_bit= c & 1;
             
             if(c_bit==0 && (a_bit==1 && b_bit==1)){
                 count+=2;
             }
             else if(c_bit==0 && (a_bit==1 || b_bit==1)){
                 count+=1;
             }
             else if(c_bit==1 && (a_bit==0 && b_bit==0)){
                 count+=1;
             }
             
             
             a >>= 1;
             b >>= 1;
             c >>= 1;    
        }
        return count;
    }
}
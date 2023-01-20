class Solution {
   public int minimizeXor(int num1, int num2) {
        if(num1 == num2) return num1;
		
        int bit = Integer.bitCount(num2);
		
      char ans[]=new char[32];
       Arrays.fill(ans,'0');

        for(int i=31;i>=0;i--) {
			int currBit = (num1 >> i) & 1;
            if(currBit == 1 && bit > 0) {
				ans[i]='1';
                bit--;
            }
        }
        
		// if bits to set are remaining, set the `LSB`
        for(int i=0;i<32;i++) {
            if(bit == 0) break;
			
            if(ans[i]=='0') {
                ans[i]='1';
                bit--;
            }
        }
       int flag = 1, binary=0;
        
        for(int i=0;i<32;i++){
            if(ans[i] == '1'){
                binary+=flag;
            }
            flag*=2;
        }
        return binary;
      
        
    }
}
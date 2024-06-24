class Solution {
    public int minKBitFlips(int[] nums, int k) {
         int n = nums.length;
        int answer = 0;
        int count = 0;
        for(int i=0; i<n; i++) {
            // if previously flipped bit has gone out of range, reduce number of flips
            if(i-k >= 0 && nums[i-k] == -1) {
                count--;
            }
            
            // check if we need to flip
            if((nums[i] + count) % 2 == 0) {
                // check if flips can be performed
                if(i <= n-k) {
                    // set current position as flip position
                    nums[i] = -1;
                    count++;
                    answer++;   
                }
                // flip cannot be done
                else {
                    return -1;
                }
            }
        }
        return answer;
    }
}
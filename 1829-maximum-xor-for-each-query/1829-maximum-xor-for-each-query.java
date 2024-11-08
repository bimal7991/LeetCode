class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;
        for (int n : nums)
            xor ^= n;

        int[] answer = new int[nums.length];
        int MAX = (int) Math.pow(2, maximumBit) - 1; // (1 << maximumBit) - 1
        for (int i = 0; i < nums.length; i++) {
            answer[i] = xor ^ MAX;
            xor ^= nums[nums.length - 1 - i];
        }
        
        return answer;
    }
}
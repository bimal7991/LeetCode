
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove elements that are not in the current window
            while (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }
            
            // Remove elements that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            
            // Add the current element to the deque
            deque.addLast(i);
            
            // Add the maximum element in the current window to the result
            if (i >= k - 1) {
                result.add(nums[deque.getFirst()]);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}
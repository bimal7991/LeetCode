class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // Create a stack to store the indices of the bars
        int maxArea = 0; // Initialize the maximum area to be 0
        
        for (int i = 0; i < heights.length; i++) {
            // Pop the previous bar from the stack as long as it is taller than the current bar
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            
            stack.push(i);
        }
        
        // Calculate the areas of the remaining rectangles in the stack
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        
        return maxArea;
    }
}
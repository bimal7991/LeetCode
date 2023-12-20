class Solution {
    public int buyChoco(int[] prices, int money) {
        
        Arrays.sort(prices);
        int sum = prices[0] + prices[1];
        
        return (money - sum) < 0 ? money : (money - sum);
    }
}
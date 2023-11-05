class Solution {
    public int getWinner(int[] arr, int k) {
        int winner = arr[0];
        int wins = 0;
        for(int i = 1; i < arr.length; i++){
            if(winner > arr[i])
			    // increment wins count
                wins++;
            else{
                wins = 1;
				// new winner
                winner = arr[i];
            }
            if(wins == k)
			    // if wins count is k, then return winner 
                break;
        }
        return winner;
    }
}
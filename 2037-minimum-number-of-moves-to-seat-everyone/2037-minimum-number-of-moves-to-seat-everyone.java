class Solution {
    public int minMovesToSeat(int[] seats, int[] st) {
        Arrays.sort(seats);
        Arrays.sort(st);
        int moves=0;
        for(int i=0;i<st.length;i++){
            moves+=Math.abs(st[i]-seats[i]);
        }
        return moves;
    }
}
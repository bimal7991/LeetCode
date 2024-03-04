class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
       Arrays.sort(tokens);
       int i=0;
       int j=tokens.length-1;
       int scores=0; 
        int max=0;
        while(i<=j){
            if(power>=tokens[i]){
                scores++;
                max=Math.max(scores,max);
                power=power-tokens[i];
                i++;
            }
            else {
                if(scores>0){
                    scores--;
                    power=power+tokens[j];
                    j--;
                }
                else
                    break;
            }
        }
        return max;
    }
}
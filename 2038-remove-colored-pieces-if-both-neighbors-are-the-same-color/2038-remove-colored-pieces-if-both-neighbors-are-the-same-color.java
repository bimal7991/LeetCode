class Solution {
    public boolean winnerOfGame(String colors) {
        int count=0;
        for(int i=1;i<colors.length()-1;i++){
            if(colors.charAt(i)=='A' && colors.charAt(i-1)=='A' && colors.charAt(i+1)=='A')
                count++;
            else if(colors.charAt(i)=='B' && colors.charAt(i-1)=='B' && colors.charAt(i+1)=='B')
                count--;
                
            
        }
        return count>=1;
    }
}
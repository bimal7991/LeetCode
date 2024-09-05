public class Solution {
    public int[] MissingRolls(int[] rolls, int mean, int n) {
        int sum=0;
        foreach(int c in rolls){
            sum=sum+c;
        }
        int remsum=(rolls.Count()+n)*mean-sum;
        if((n*6)<remsum || remsum<n)
            return new int[]{};
         int[] ans=new int[n];
         int rem=remsum%n;
         for(int i=0;i<n;i++)
             ans[i]=(remsum/n);
         for(int i=0;i<n && rem>0;i++)
         {
             ans[i]=ans[i]+1;
             rem--;
         }
        return ans;
    } 
}
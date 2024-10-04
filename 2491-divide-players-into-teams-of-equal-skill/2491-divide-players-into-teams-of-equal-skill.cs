public class Solution {
    public long DividePlayers(int[] skill) {
        Array.Sort(skill);
        int i=0,j=skill.Count()-1;
        long ans=0;
        while(i<j){
            if(skill[i]+skill[j]!=skill[0]+skill[skill.Count()-1])
                return -1;
            ans=ans+skill[i]*skill[j];
            i++;
            j--;
        }
        return ans;
    }
}
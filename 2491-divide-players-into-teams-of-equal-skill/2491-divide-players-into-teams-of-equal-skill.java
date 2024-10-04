class Solution {
    public long dividePlayers(int[] skill) {
        long ans=0;
        int i=0,j=skill.length-1;
        Arrays.sort(skill);
        int sum=skill[i]+skill[j];
        ans=skill[i]*skill[j];
        i++;j--;
        while(i<j){
            if(skill[i]+skill[j]!=sum){
                return -1;
            }
            ans+=(skill[i]*skill[j]);
            i++;
            j--;
            
        }
        return ans;
    }
}
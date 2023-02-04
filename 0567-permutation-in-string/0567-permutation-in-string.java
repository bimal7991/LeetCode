class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq1[]=new int[26];
        for(char c:s1.toCharArray()){
            freq1[c-'a']++;
        }
        
        int i=0;
        int j=0;
        int n=s2.length();
        int freq2[]=new int[26];
        while(j<n){
            char c=s2.charAt(j);
            freq2[c-'a']++;
            
            if(Arrays.equals(freq1,freq2))
                return true;
            else if(freq2[c-'a']>freq1[c-'a']){
                while(freq2[c-'a']>freq1[c-'a']){
                    char f=s2.charAt(i);
                    freq2[f-'a']--;
                    i++;
                }
                if(Arrays.equals(freq1,freq2))
                return true;
            }
            j++;
            
        }
        return false;
    }
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int freq1[]=new int[26];
        for(char c:p.toCharArray()){
            freq1[c-'a']++;
        }
        
        int i=0;
        int j=0;
        int n=s.length();
        int freq2[]=new int[26];
        while(j<n ){
            char c=s.charAt(j);
            freq2[c-'a']++;
            
            if(Arrays.equals(freq1,freq2)){
                list.add(i);
                freq2[s.charAt(i)-'a']--;
                i++;
            }
                
            else if(freq2[c-'a']>freq1[c-'a']){
                while(freq2[c-'a']>freq1[c-'a']){
                    char f=s.charAt(i);
                    freq2[f-'a']--;
                    i++;
                }
                if(Arrays.equals(freq1,freq2)){
                     list.add(i);
                    freq2[s.charAt(i)-'a']--;
                    i++;
                }
               
            }
            j++;
            
        }
        return list;
    }
}
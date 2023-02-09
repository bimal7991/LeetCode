class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String> arr[]=new HashSet[26];
        for(int i=0;i<26;i++){
            arr[i]=new HashSet<String>();
        }
        for(String s:ideas){
            arr[s.charAt(0)-'a'].add(s.substring(1));
        }
        long ans=0;
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){
                long countI=0;
                long countJ=0;
                for(String s:arr[i]){
                    if(!arr[j].contains(s))
                        countI++;
                }
                for(String s:arr[j]){
                    if(!arr[i].contains(s))
                        countJ++;
                }
                ans=ans+(countI*countJ);
            }
        }
        return ans*2;
    }
}
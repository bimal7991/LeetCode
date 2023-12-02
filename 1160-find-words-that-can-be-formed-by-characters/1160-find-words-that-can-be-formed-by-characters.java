class Solution {
    public int countCharacters(String[] words, String chars) {
      int freq[]=new int[26];
        for(char c:chars.toCharArray()){
            freq[c-'a']++;
        }
        int sum=0;
        for(String w:words){
            if(canForm(w,freq)){
                sum=sum+w.length();
            }
        }
        return sum;
        
    }
    boolean canForm(String s,int freq[]){
        int arr[]=new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(arr[i]>freq[i])
                return false;
        }
        return true;
    }
}
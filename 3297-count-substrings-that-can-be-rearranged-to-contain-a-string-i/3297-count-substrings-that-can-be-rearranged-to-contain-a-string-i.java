class Solution {
    public long validSubstringCount(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();

        if (word2Len > word1Len) return 0;

        int[] word2Freq = new int[26];
        for (char c : word2.toCharArray()) {
            word2Freq[c - 'a']++;
        }

        long count = 0;
        int[] windowFreq = new int[26];
        int validCount = 0; 
        int start=0;
        for (int end = 0; end < word1Len; end++) {
            char addChar = word1.charAt(end);
            windowFreq[addChar - 'a']++;
            while(isValidPrefix(windowFreq,word2Freq)){
                count+=(word1Len-end);
                windowFreq[word1.charAt(start)-'a']--;
                start++;
            }
            
           
        }

        return count;
    }
    public boolean isValidPrefix(int[] windowFreq, int[] word2Freq) {
       
        for (int i = 0; i < 26; i++) {
            if (windowFreq[i] < word2Freq[i]) {
                return false;
            }
        }
        
        return true;
    }
}
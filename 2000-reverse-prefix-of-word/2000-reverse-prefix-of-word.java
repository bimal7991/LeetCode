class Solution {
    public String reversePrefix(String word, char ch) {
        int i=word.indexOf(ch);
        return new StringBuilder(word.substring(0,i+1)).reverse()+word.substring(i+1);
    }
}
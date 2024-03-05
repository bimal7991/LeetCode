class Solution {
    public int minimumLength(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                break;
            else{
                char c=s.charAt(i);
                while(i<=j && s.charAt(i)==c)
                    i++;
                while(i<=j && s.charAt(j)==c)
                    j--;
            }
        }
        return j-i+1;
    }
}
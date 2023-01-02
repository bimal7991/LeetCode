class Solution {
    public boolean detectCapitalUse(String word) {
        boolean first=false;
        int n=word.length();
        if(word.charAt(0)>='A' && word.charAt(0)<='Z')
            first=true;
        int count=0;
        for(int i=1;i<word.length();i++){
           
                 if(word.charAt(i)>='a' && word.charAt(i)<='z')
                        count++;    
            
        }
        if(first)
            if(count==n-1 || count==0)
            return true;
            else
            return false;
        else{
            if(count==n-1)
            return true;
            else
            return false;
        }
        
    }
}
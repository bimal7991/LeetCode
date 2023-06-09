class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char c=letters[0];
        int low=0;
        int high=letters.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(letters[mid]-'a' > target-'a'){
                c=letters[mid];
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return c;
    }
}
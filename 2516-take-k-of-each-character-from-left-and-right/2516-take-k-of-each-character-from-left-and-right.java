class Solution {
    public int takeCharacters(String s, int k) {
        int arr[]=new int[3];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        if(arr[0]<k || arr[1]<k || arr[2]<k)
            return -1;
        arr[0]=arr[0]-k;
        arr[1]=arr[1]-k;
        arr[2]=arr[2]-k;
        int i=0,j=0,max=0;
        while(j<s.length()){
            char c=s.charAt(j);
            arr[c-'a']--;
            while(arr[c-'a']<0){
                arr[s.charAt(i)-'a']++;
                i++;
            }
            max=Math.max(j-i+1,max);
            j++;
        }
        return s.length()-max;
    }
}
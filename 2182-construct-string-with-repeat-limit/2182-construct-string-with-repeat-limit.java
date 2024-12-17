class Solution {
    public String repeatLimitedString(String s, int limit) {
        int arr[]=new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=25;i>=0;i--){
            if(arr[i]==0)
                continue;
            char c= (char)(i+'a');
            while(arr[i]>0){
            int k=0;
            while(arr[i]>0 && k<limit){
                ans.append(c);
                arr[i]--;
                k++;
            }
            if(arr[i]>0){
                int ind=findIndex(arr,i);
                if(ind==-1)
                    break;
                ans.append((char)(ind+'a'));
                arr[ind]--;
             }
            }
            
            
        }
        return  ans.toString();
    }
    int findIndex(int arr[],int i){
        for(int j=i-1;j>=0;j--){
            if(arr[j]>0)
                return j;
        }
        return -1;
    }
}
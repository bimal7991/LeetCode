class Solution {
    public int minDeletions(String s) {
        int arr[]=new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        Arrays.sort(arr);
        int sum=0;
        for(int i=24;i>=0;i--){
            if(arr[i]==0)
                break;
            if(arr[i+1]<=arr[i]){
                int rem=arr[i+1]-1;
                sum=sum+arr[i]-(rem<0?0:rem);
                arr[i]=rem;
            }
        }
        return sum;
    }
}
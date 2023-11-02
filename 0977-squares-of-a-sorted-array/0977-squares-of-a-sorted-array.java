class Solution {
    public int[] sortedSquares(int[] arr) {
        int n=arr.length;
    int ans[]=new int[n];
    int i=0;
    int j=n-1;
    n--;
    while(i<=j){
      if(Math.abs(arr[i])>Math.abs(arr[j])){
        ans[n--]=arr[i]*arr[i];
        i++;
      }
      else{
        ans[n--]=arr[j]*arr[j];
        j--;     
      }
    }
    
    return ans;
    }
}
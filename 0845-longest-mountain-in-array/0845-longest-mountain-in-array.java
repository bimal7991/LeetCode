class Solution {
    public int longestMountain(int[] arr) {
        int i=0;
        int j=1;
        int max=0;


        while(j<arr.length){
            int count=1;
            if(arr[j]<=arr[j-1])
            {
                j++;
                continue;
            }
            while(j<arr.length && arr[j]>arr[j-1]){
                count++;
                j++;
            }
            if(j>=arr.length || arr[j]==arr[j-1])
                continue;

            while(j<arr.length && arr[j]<arr[j-1]){
                count++;
                j++;
            }
            max=Math.max(count,max);

        }
        return max;
    }
}
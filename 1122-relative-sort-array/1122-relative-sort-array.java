class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int hs[]=new int[1001];
        for(int i:arr1)
            hs[i]++;
        int ans[]=new int[arr1.length];
        Arrays.sort(arr1);
        int i=0,j=0;
        while(i<arr2.length){
            for(int k=0;k<hs[arr2[i]];k++){
                ans[j++]=arr2[i];
            }
            hs[arr2[i]]=0;
            i++;
        }
        for(int m:arr1){
            if(hs[m]!=0){
                for(int k=0;k<hs[m];k++){
                ans[j++]=m;
               }
                hs[m]=0;
            }
        }
        
        return ans;
    }
}
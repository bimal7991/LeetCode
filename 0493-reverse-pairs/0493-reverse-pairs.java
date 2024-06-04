
class Solution {
    int count=0;
    public int reversePairs(int[] arr) {
       return mergeSort(arr, 0, arr.length-1);
    }

   public int mergeSort(int arr[],int l,int r){
        int count=0;
        if(l<r){
            int mid=(l+r)/2;
            count=count+mergeSort(arr,l,mid);
            count=count+mergeSort(arr,mid+1,r);
            count=count+merge(arr,l,mid,r);
            
        }
        return count;
    }
   public int merge(int arr[],int l,int mid,int r){
       int count=0;
       int l_start=l;
       int r_start=mid+1;
       ArrayList<Integer> list=new ArrayList<>();
       while(l_start<=mid && r_start<=r){
             if(arr[l_start]>(2*(long)arr[r_start])){
                  count=count+mid-l_start+1;
                  r_start++;
             }
          else{
              l_start++;
          }
           
       }
        Arrays.sort(arr,l,r+1);
        return count;
   }

}
class Solution {
    public int minDays(int[] arr, int m, int k) {
        if( (long)m*k>arr.length)
            return -1;
        int low=1;
        int high=getMax(arr);
        while(low<high){
            int mid=(high+low)/2;
            if(canMake(arr,mid,m, k)){
                high=mid;
            }
            else
                low=mid+1;
        }
        return low;
        
        
    }
    boolean canMake(int arr[],int mid,int m,int k){
        int j=0;
        int count=0;
        while(j<arr.length){
            if(mid>=arr[j]){
                count++;
                if(count==k)
                {
                    m--;
                    count=0;
                }
                j++;
                
            }else{
                count=0;
                j++;
            }
            
            
        }
        if(m<=0)
            return true;
        else
            return false;
        
    }
    
    int getMax(int arr[]){
        int max=0;
        for(int x:arr){
            max=Math.max(x,max);
        }
        return max;
    }
    
}
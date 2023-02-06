//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return mergeSort(arr,0,(int)(N-1));
    }
  static  long mergeSort(long arr[],int l,int r){
        long inv=0;
        if(l<r){
            int mid=(l+r)/2;
            inv+=mergeSort(arr,l,mid);
            inv+=mergeSort(arr,mid+1,r);
            inv+=merge(arr,l,mid,r);
        }
        return inv;
    }
   static long merge(long arr[],int l,int mid,int r){
       long inv=0;
       long left[]=Arrays.copyOfRange(arr,l,mid+1);
       long right[]=Arrays.copyOfRange(arr,mid+1,r+1);
       int k=l;
       int i=0,j=0;
       while(i<left.length && j<right.length){
           if(left[i]<=right[j]){
               arr[k++]=left[i++];
           }
           else{
               arr[k++]=right[j++];
               inv=inv+(left.length-i);
           }
       }
       while(i<left.length){
           arr[k++]=left[i++];
       }
        while(j<right.length){
           arr[k++]=right[j++];
       }
       return inv;
        
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)   
            return findMedianSortedArrays(nums2,nums1);
        int n1=nums1.length,n2=nums2.length;
        int mid=(n1+n2+1)/2;
        int low=0,high=n1;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=mid-mid1;
            int l1= (mid1-1)>=0?nums1[mid1-1]:Integer.MIN_VALUE;
             int l2= (mid2-1)>=0?nums2[mid2-1]:Integer.MIN_VALUE;
            int r1=mid1<n1?nums1[mid1]:Integer.MAX_VALUE;
            int r2=mid2<n2?nums2[mid2]:Integer.MAX_VALUE;
            // System.out.println(l1+" "+r1+" "+l2+" "+r2);
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==1)
                    return Math.max(l1,l2);
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
           if(l1>r2)
                high=mid1-1;
            else
                low=mid1+1;
        }
        return 0.0;
    }
}
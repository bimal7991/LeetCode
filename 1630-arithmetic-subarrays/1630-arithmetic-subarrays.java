class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            list.add(canArrange(l[i],r[i],nums));
        }
        return list;
    }
    boolean canArrange(int l,int r,int nums[]){
        int arr[]=new int[r-l+1];
        int k=0;
        for(int i=l;i<=r;i++)
            arr[k++]=nums[i];
        Arrays.sort(arr);
        int diff=arr[1]-arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]!=diff)
                return false;
        }
        return true;
        
    }
}
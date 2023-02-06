class Solution {
    public int[] shuffle(int[] nums, int n) {
        int l=nums.length;
        int arr[]=new int[l];
        int i=0;
        int j=l/2;
        for(int k=0;k<l;){
            arr[k++]=nums[i++];
            arr[k++]=nums[j++];
        }
        return arr;
        
    }
}
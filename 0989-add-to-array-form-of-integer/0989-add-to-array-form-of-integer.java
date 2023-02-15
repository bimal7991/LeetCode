class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        int n=nums.length-1;
       List<Integer> arr=new ArrayList<Integer>();
        int c=0;
        while(n>=0 || k>0){
            int dig=0,num=0;
            if(k>0){
                dig=k%10;
                k=k/10;
            }
            if(n>=0){
                num=nums[n];
                n--;
            }
            int sum=dig+num+c;
            c=sum/10;
            arr.add(sum%10);
        }
        if(c>0)
            arr.add(c);
       Collections.reverse(arr);
        return arr;
    }
}
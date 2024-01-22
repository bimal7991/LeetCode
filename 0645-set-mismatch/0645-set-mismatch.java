class Solution {
    public int[] findErrorNums(int[] nums) {
       HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=1;i<=nums.length;i++){
            hs.add(i);
        }
        int arr[]=new int[2];
        
        for(int i:nums){
            if(hs.contains(i))
                hs.remove(i);
            else{
                arr[0]=i;
            }
               
        }
        for(int i:hs)
            arr[1]=i;
        return arr;
    }
}
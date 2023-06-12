class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList<>();
        if(nums.length==0)
            return list;
        int prev=nums[0];
        int start=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==prev+1){
                prev=nums[i];
            }
            else{
                if(start!=prev){
                String s=""+start+"->"+prev;
                list.add(s);
                }
                else
                    list.add( ""+prev);
                start=nums[i];
                prev=nums[i];
                
            }
        }
        if(start!=prev){
                String s=""+start+"->"+prev;
                list.add(s);
                }
                else
                    list.add( ""+prev);
        return list;
    }
}
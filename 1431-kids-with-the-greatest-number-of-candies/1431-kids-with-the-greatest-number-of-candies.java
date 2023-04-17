class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int ex) {
        int max=0;
        for(int i:candies){
            max=Math.max(max,i);
        }
        List<Boolean> list=new ArrayList<>();
        for(int i:candies){
            if(i+ex>=max){
                list.add(true);
            }
            else
                list.add(false);
        }
        return list;
    }
}
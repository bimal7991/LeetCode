class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(int i:hm.values()){
            list.add(i);
        }
        Collections.sort(list);
        int s=list.size();
        for(int i:list){
            if(k>=i){
                k=k-i;
                s--;
            }
        }
        return s;
    }
}
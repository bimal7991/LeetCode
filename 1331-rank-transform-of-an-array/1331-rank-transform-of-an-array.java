class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> hs=new HashSet<Integer>();
        for(int i:arr)
            hs.add(i);
        List<Integer> list=new ArrayList<>(hs);
        Collections.sort(list);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<list.size();i++){
            hm.put(list.get(i),i+1);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=hm.get(arr[i]);
        }
        return arr;
        
    }
}
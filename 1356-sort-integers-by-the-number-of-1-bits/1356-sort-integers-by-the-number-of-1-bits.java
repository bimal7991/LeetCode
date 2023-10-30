class Solution {
    public int[] sortByBits(int[] arr) {
        HashMap<Integer,LinkedList<Integer>> hm=new HashMap<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
               int count=countSetBits(arr[i]);
            if(hm.containsKey(count)){
                LinkedList<Integer> list=hm.get(count);
                list.add(arr[i]);
                hm.put(count,list);
            }else{
                 LinkedList<Integer> list=new LinkedList<>();
                list.add(arr[i]);
                hm.put(count,list);
            }
              
        }
        int ans[]=new int[arr.length];
        int k=0;
        for(List<Integer> list:hm.values()){
            
            for(int i:list)
                ans[k++]=i;
        }
        
        return ans;
    }
    int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
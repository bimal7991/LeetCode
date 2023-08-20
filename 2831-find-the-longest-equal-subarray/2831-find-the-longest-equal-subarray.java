class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<nums.size();i++){
            if(hm.containsKey(nums.get(i))){
                List<Integer> list=hm.get(nums.get(i));
                list.add(i);
                hm.put(nums.get(i),list);
            }
            else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                hm.put(nums.get(i),list);
            }
        }
       
        int p=1;
        int max=1;
        for(int m:hm.keySet()){
            List<Integer> list=hm.get(m);
            int i=1,j=0;
            int count=0;
            while(i<list.size()){
                count+=list.get(i)-list.get(i-1)-1;
                while(count>k){
                    count-=list.get(j+1)-list.get(j)-1;
                    j++;
                }
                max=Math.max(i-j+1,max);
                i++;
            }
            
        }
        return max;
        
    }
    boolean canEqual(HashMap<Integer,List<Integer>> hm,int mid,int k){
        for(int i:hm.keySet()){
            List<Integer> list=hm.get(i);
            if(list.size()>=mid){
                int count=0;
                int p=1;
                int max=1;
                for(int j=1;j<list.size();j++){
                    if(list.get(j)==list.get(j-1)+1){
                        p++;
                        max=Math.max(p,max);
                    }
                    else
                        p=1;
                    count+=list.get(j)-list.get(j-1)-1;
                    
                    
                }
                if(count<=k || max>=mid)
                    return true;
            }
        }
        return false;
    }
}
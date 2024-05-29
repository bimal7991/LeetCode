class Solution {
    public int numSteps(String s) {
        List<Character> list=new ArrayList<>();
        for(char c:s.toCharArray()){
            list.add(c);
        }
        int count=0;
        while(list.size()!=1){
            if(list.get(list.size()-1)=='1'){
                list.set(list.size()-1,'0');
                int k=list.size()-2;
                while(k>=0 && list.get(k)=='1'){
                    list.set(k,'0');
                    k--;
                }
                if(k>=0)
                    list.set(k,'1');
                else{
                    list.add(0,'1');
                    
                }
            }
            else{
                list.remove(list.size()-1);
            }
            System.out.println(list);
            count++;
        }
        return count;
    }
}
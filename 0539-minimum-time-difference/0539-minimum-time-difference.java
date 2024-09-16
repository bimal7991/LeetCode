class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list=new ArrayList<Integer>();
        for(String s:timePoints){
            list.add(timeStringToInt(s));
        }
        Collections.sort(list);
        list.add(list.get(0)+2400);
        // System.out.println(list);
        int max=2500;
        for(int i=0;i<list.size()-1;i++){
            int a=list.get(i);
            int b=list.get(i+1);
            int bm=(b/100)*100;
             // System.out.print(bm+" ");
            int am=(a/100)*100+100;
            int diff=b-bm + ((b/100)-(a/100)-1)*60 + am-40-a;
            // System.out.print(diff+" ");
            max=Math.min(diff,max);
        }
        
        
        return max;
    }
    public int timeStringToInt(String s){
        String str[]=s.split(":");
        return Integer.parseInt(str[0])*100+Integer.parseInt(str[1]);
    }
}
class Solution {
    public List<List<Integer>> generate(int numRows) {
     List<List<Integer>> arr=new ArrayList<List<Integer>>();
        ArrayList<Integer> sub=new ArrayList<Integer>();
        sub.add(1);
        arr.add(sub);
        if(numRows==1)
            return arr;
        ArrayList<Integer> sub2=new ArrayList<Integer>();
        sub2.add(1);
        sub2.add(1);
        arr.add(sub2);
        
        if(numRows==2)
            return arr;
        for(int i=2;i<numRows;i++){
            ArrayList<Integer> sub1=new ArrayList<Integer>();
            sub1.add(1);
            for(int j=1;j<i;j++){
                  sub1.add(arr.get(i-1).get(j-1)+arr.get(i-1).get(j));
            }
            sub1.add(1);
            arr.add(sub1);
        }
        return arr;   
    }
}
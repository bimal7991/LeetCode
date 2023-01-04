class Solution {
    public int maxPoints(int[][] points) {
        int max=0;
        if(points.length==1)
            return 1;
       
        for(int i=0;i<points.length;i++){
             HashMap<Double,Integer> hm=new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i==j)
                    continue;
                double x=points[i][0]-points[j][0];
                double y=points[i][1]-points[j][1];
                hm.put( (y/x),hm.getOrDefault(y/x,1)+1);
            }
            for(Double k:hm.keySet()){
             max=Math.max(max,hm.get(k));
            }
           
        }
        
        return max;
    }
}
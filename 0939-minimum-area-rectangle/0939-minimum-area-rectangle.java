class Solution {
    public int minAreaRect(int[][] coords) {
       HashSet<String> hs=new HashSet<>();
      for(int c[]:coords){
          hs.add(c[0]+"*"+c[1]);
      }
        int min=Integer.MAX_VALUE;
      for(int p1[]:coords){
          for(int p2[]:coords){
              if(p1[0]==p2[0] || p1[1]==p2[1])
                  continue;
              if(hs.contains(p1[0]+"*"+p2[1]) && hs.contains(p2[0]+"*"+p1[1]))
              {
                  int area= Math.abs(p1[0]-p2[0])* Math.abs(p1[1]-p2[1]);
                  min=Math.min(min,area);
              }
          }
      }
        
        return min==Integer.MAX_VALUE?0:min;
    }
}
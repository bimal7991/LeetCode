class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<RowSold> pq=new PriorityQueue<>((a,b)->{
            if(a.sold==b.sold)
                return a.row-b.row;
            else
                return a.sold-b.sold;
        });
        for(int i=0;i<mat.length;i++){
            int count=countOne(mat[i]);
            
            pq.add(new RowSold(i,count));
        }
        int arr[]=new int[k];
        for(int i=0;i<k;i++){
            arr[i]=pq.remove().row;
        }
        return arr;
    }
    int countOne(int row[]){
        int low=0;
        int high=row.length-1;
      while(low<=high){
          int mid=(low+high)/2;
          if(row[mid]==1)
              low=mid+1;
           else
               high=mid-1;
          
      }
        return low;
        
        
    }
    
}
class RowSold{
    int row, sold;
    RowSold(){};
    RowSold(int r,int s){
        row=r;
        sold=s;
    }
}
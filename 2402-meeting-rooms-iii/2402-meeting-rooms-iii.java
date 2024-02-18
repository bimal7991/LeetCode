class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        int arr[]=new int[n];
        int ans[]=new int[n];
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->a[0]==b[0]?a[2]-b[2]:a[0]-b[0]);
        int time=0;
        for(int m[]:meetings){
             while(!pq.isEmpty() && m[0]>=pq.peek()[0]){
                   int p[]=pq.poll();
                   arr[p[2]]=0; 
                }
             int i=findEmptyRoom(arr);
            if(i!=n)
            {
                arr[i]=1;
                ans[i]++;
                pq.add(new int[]{m[1],m[0],i});
            }
            else { 
                   int p[]=pq.poll();
                   int end=p[0]+(m[1]-m[0]);
                   ans[p[2]]++;
                   arr[p[2]]=1;
                   pq.add(new int[]{end,p[0],p[2]}); 
                
            }
        }
        // System.out.println(Arrays.toString(ans));
        int ind=0;
        int max=0;
        for(int i=0;i<n;i++){
            if(ans[i]>max)
            {
                max=ans[i];
                ind=i;
            }
        }
        return ind;
        
        
    }
    int findEmptyRoom(int arr[]){
        int n=arr.length;
            int i=0;
            while(i<n && arr[i]==1){
                i++;
            }
        return i;
    }
}
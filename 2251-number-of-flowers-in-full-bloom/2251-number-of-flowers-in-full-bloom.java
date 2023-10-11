class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int i=0;i<people.length;i++){
            pq.add(  new int[]{people[i],1,i});
        }
        for(int f[]:flowers){
            pq.add(new int[]{f[0],0});
            pq.add(new int[]{f[1],2});
        }
        int ans[]=new int[people.length];
        int size=pq.size();
        int count=0;
        for(int i=0;i<size;i++){
            int curr[]=pq.poll();
            if(curr[1]==0)
                count++;
            else if(curr[1]==2)
                count--;
            else{
                ans[curr[2]]=count;
            }
        }
        return ans;
    }
}
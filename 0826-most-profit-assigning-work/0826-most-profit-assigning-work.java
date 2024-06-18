class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n=difficulty.length;
        Job jobs[]=new Job[n];
        for(int i=0;i<n;i++){
            jobs[i]=new Job(difficulty[i],profit[i]);
        }
        Arrays.sort(jobs,(a,b)->a.d-b.d);
        int maxProfit[]=new int[100001];
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,jobs[i].p);
            maxProfit[jobs[i].d]=max;
        }
        for(int i=0;i<100001;i++){
            if(i>0 && maxProfit[i]==0)
                maxProfit[i]=maxProfit[i-1];
        }
        int sum=0;
        for(int i:worker){
            sum+=maxProfit[i];
        }
        return sum;
    }
}
class Job{
    int d,p;
    Job(int d,int p){
        this.d=d;
        this.p=p;
    }
}
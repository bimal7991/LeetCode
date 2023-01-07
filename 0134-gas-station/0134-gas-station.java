class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ind=0;
        int n=gas.length;
        int max=0;
        int sum=0;
        int total=0;
        for(int i=0;i<n;i++){
            sum=sum+gas[i]-cost[i];
            total=total+gas[i]-cost[i];
            if(sum<0)
            {
                ind=i+1;
                sum=0;
            }
            
            
            
        }
        if(total<0)
            return -1;
        return ind;
         
    }
}
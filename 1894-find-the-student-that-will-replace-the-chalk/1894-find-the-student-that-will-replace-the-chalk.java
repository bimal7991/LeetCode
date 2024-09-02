class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        for(int i:chalk){
            sum+=i;
        }
        long p=(long)k%sum;
        for(int i=0;i<chalk.length;i++){
            if(p-chalk[i]<0)
                return i;
            p=p-chalk[i];
        }
        return -1;
    }
}
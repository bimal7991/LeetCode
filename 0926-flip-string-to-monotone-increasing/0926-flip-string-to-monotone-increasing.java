class Solution {
    public int minFlipsMonoIncr(String s) {
        ArrayList<int[]> front=new ArrayList<>();
        ArrayList<int[]> back=new ArrayList<>();
        int zero=0;
        int one=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')
                zero++;
            else
                one++;
            front.add(new int[]{zero,one});
        }
        zero=0;
        one=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0')
                zero++;
            else
                one++;
            back.add(new int[]{zero,one});
        }
        Collections.reverse(back);
        int ans=Math.min(zero,one);
        for(int i=0;i<s.length()-1;i++){
            ans=Math.min(ans,front.get(i)[1]+back.get(i+1)[0]);
        }
        return ans;
    }
}
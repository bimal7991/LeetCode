class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=ages.length;
        Player p[]=new Player[n];
        for(int i=0;i<ages.length;i++){
            p[i]=new Player(scores[i],ages[i]);
        }
        Arrays.sort(p,(p1,p2)->p1.age==p2.age?p1.score-p2.score:p1.age-p2.age);
       HashMap<String,Integer> hm=new HashMap<>();
        return helper(p);
        
    }
    int helper(Player p[]){
        int n=p.length;
        int dp[]=new int[n+1];
        int ans=0;
        dp[0] = p[0].score;
        for (int i = 1; i < n; i++) {
            int max = p[i].score; 
            for (int j = 0; j < i; j++) {
                if (p[i].score >= p[j].score) {
                    max = Math.max(max, dp[j] + p[i].score);
                }
            }
            dp[i] = max;
        }
        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        
        return res;
        
    }
}
class Player{
    int age;
    int score;
    Player(int s,int a){
        age=a;
        score=s;
    }
    Player(){}
}
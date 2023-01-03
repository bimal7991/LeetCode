//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] intervals = IntMatrix.input(br, n, 3);

            Solution obj = new Solution();
            int res = obj.maximum_profit(n, intervals);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
     private static Map<Integer, Integer> dp;
    public static int maximum_profit(int n, int[][] intervals) {
         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    
    
    dp = new HashMap<>();
        return dfs(0, intervals);
        
    
    }
   static int dfs(int cur, int[][] jobs) {
        if (cur == jobs.length) {
            return 0;
        }
        
        if (dp.containsKey(cur)) {
           return dp.get(cur);
        }
        
        int next = findNext(cur, jobs);
        int inclProf = jobs[cur][2] + (next == -1 ? 0 : dfs(next, jobs));
        int exclProf = dfs(cur + 1, jobs);
        
        dp.put(cur, Math.max(inclProf, exclProf));
        return Math.max(inclProf, exclProf);
    }
    
   static int findNext(int cur, int[][] jobs) {
        for (int next = cur + 1; next < jobs.length; next++) {
            if (jobs[next][0] >= jobs[cur][1]) {
                return next;   
            }
        }
        return -1;
    }
}

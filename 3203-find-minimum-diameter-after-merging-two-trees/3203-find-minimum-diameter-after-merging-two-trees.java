class Solution {
   static int[] bfs(int root, ArrayList<Integer> arr[]){
        int ans[] = new int[2];
        int n = arr.length;
        int dist[] = new int[n];
        Arrays.fill(dist,-1);
        dist[root] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(root);

        int maxd = 0;
        int farthestNode = root;

        while(q.size()!=0){
            int a = q.remove();

            for(var x : arr[a]){
                if(dist[x]==-1){
                    dist[x] = dist[a]+1;
                    q.add(x);

                    if(dist[x]>maxd){
                        maxd = dist[x];
                        farthestNode = x;
                    }
                }
            }
        }
        return new int[]{farthestNode,maxd};
    }
    static int findDiameter(ArrayList<Integer> arr[]){
        int x1[] = bfs(0,arr);
        int x2[] = bfs(x1[0],arr);
        return x2[1];
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length;
        int m = edges2.length;

        ArrayList<Integer> arr1[] = new ArrayList[n+1];
        ArrayList<Integer> arr2[] = new ArrayList[m+1];
        for(int i=0; i<=n; i++) arr1[i] = new ArrayList<>();
        for(int i=0; i<=m; i++) arr2[i] = new ArrayList<>();

        for(var a : edges1){
            arr1[a[0]].add(a[1]);
            arr1[a[1]].add(a[0]);
        }

        for(var a : edges2){
            arr2[a[0]].add(a[1]);
            arr2[a[1]].add(a[0]);
        }

        int d1 = findDiameter(arr1);
        int d2 = findDiameter(arr2);

        return Math.max(Math.max(d1,d2),((d1+1)/2+(d2+1)/2+1));
    }
}
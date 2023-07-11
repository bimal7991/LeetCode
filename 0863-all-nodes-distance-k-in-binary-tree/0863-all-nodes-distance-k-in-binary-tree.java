/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     int vis[]=new int[501];
     int dis[]=new int[501];
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Arrays.fill(dis,-1);
        ArrayList<Integer> arr[]=new ArrayList[501];
        for(int i=0;i<=500;i++){
            arr[i]=new ArrayList<Integer>();
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null){
                    arr[temp.val].add(temp.left.val);
                    arr[temp.left.val].add(temp.val);
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    arr[temp.val].add(temp.right.val);
                    arr[temp.right.val].add(temp.val);
                    q.add(temp.right);
                }
            }
        }
        dfs(target.val,arr,0);
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<=500;i++){
            if(dis[i]==k)
                ans.add(i);
        }
        return ans;
    }
void dfs(int node, ArrayList<Integer>[] arr,int d) {
	if(vis[node]==1) {
		return;
	}
	dis[node]=d;
	vis[node]=1;
		for(int i=0;i<arr[node].size();i++) {
			int child = arr[node].get(i);
			if (vis[child] != 1) {
				dfs(child, arr, dis[node] + 1);
			}
		}
 }
    
    
}
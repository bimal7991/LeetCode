/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        
        ArrayList<Integer> arr[]=new ArrayList[100001];
        for(int i=0;i<100001;i++) {
            arr[i]=new ArrayList<Integer>();

        }
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp=st.pop();
            if(temp.left!=null)
            {
                arr[temp.val].add(temp.left.val);
                arr[temp.left.val].add(temp.val);
                st.push(temp.left);
            }
            if(temp.right!=null) {
                arr[temp.val].add(temp.right.val);
                arr[temp.right.val].add(temp.val);
                st.push(temp.right);
            }
        }
       // for(int i=0;i<=10;i++){
       //     System.out.println(arr[i]);
       // }
       
        bfs(start,arr);
			
	  // directed graph
        int max=0;
			for(int i=1;i<=100000;i++)
			max=Math.max(max,dis[i]);
        return max;
           
    }
     int vis[]=new int[1000001];
	 int dis[]=new int[1000001];
    public void bfs(int node, ArrayList<Integer>[] arr) {	
		Queue<Integer> queue=new LinkedList<Integer>();
		dis[node]=0;
		vis[node]=1;
		queue.add(node);
		//System.out.println(node);
		while(!queue.isEmpty()) {
			int curr=queue.peek();
			queue.remove();
			for(int child:arr[curr]) {
				
				if(vis[child]==0) {
					//System.out.println(child);
					vis[child]=1;
					queue.add(child);
					dis[child]=dis[curr]+1;
				}
			}
			
		}
	}
    
}
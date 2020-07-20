package SwordToOffer;

public class T54 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
//	给定一棵二叉搜索树，请找出其中第k大的节点。
//	中序遍历
	 
	
	private int cnt,K,ans;
	private boolean startcnt;
    public int kthLargest(TreeNode root, int k) {
    	K=k;
    	cnt = 0;
    	dfs(root);
    	return ans;
    }
    
    private void dfs(TreeNode root){
    	if(root==null || cnt>K){
    		if(!startcnt)
    			startcnt = true;
    		return;
    	}
    	
    	dfs(root.right);
    	cnt++;
    	if(cnt==K) ans = root.val;
    	dfs(root.left);
    }
}

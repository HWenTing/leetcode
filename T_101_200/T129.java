package T_101_200;

public class T129 {

//	给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//	例如，从根到叶子节点路径 1->2->3 代表数字 123。
//	计算从根到叶子节点生成的所有数字之和。
	
//	递归
//	击败98%
	
	private int ans = 0;
    public int sumNumbers(TreeNode root) {
    	dfs(root,0);
        return ans;
    }
    
    private void dfs(TreeNode root,int cur){
    	if(root==null) return;
    	cur = cur*10+root.val;
    	if(root.left==null && root.right==null){//叶节点
    		ans+=cur;
    		return;
    	}
    	dfs(root.left,cur);
    	dfs(root.right,cur);
    }

}




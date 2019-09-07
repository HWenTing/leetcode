package T_901_1000;

public class T979 {

	
//	N个节点和为N，每次移动1在父节点与子节点之间（双向），使各个节点的值均为一 返回操作的最小步数
	
//	递归解决
//	一遍ac 速度击败60%
	
	private int ans=0;
    public int distributeCoins(TreeNode root) {
    	dfs(root);
    	return ans;
    }
    
    private int dfs(TreeNode root){
    	if(root==null) return 0;
    	
    	int left = dfs(root.left);//左节点的贡献
    	int right = dfs(root.right);//右节点的贡献
    	ans+=(Math.abs(left)+Math.abs(right));
    	return left+right-1+root.val;
    }
    
}





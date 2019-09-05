package T_501_600;

public class T563 {

//	给定一个二叉树，计算整个树的坡度。
//	一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
//	整个树的坡度就是其所有节点的坡度之和。
	
//	dfs,后序遍历，顺便计算坡度和sum
	private int ans=0;
    public int findTilt(TreeNode root) {
    	dfs(root);
    	return ans;
    }
    
    private int dfs(TreeNode root){
    	if(root==null) return 0;
    	int left = dfs(root.left);
    	int right = dfs(root.right);
    	ans+=Math.abs(left-right);
    	int sum =left+right+root.val;
    	return sum;
    }
}

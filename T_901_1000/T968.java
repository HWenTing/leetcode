package T_901_1000;

public class T968 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
//	给定一个二叉树，我们在树的节点上安装摄像头。
//	节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
//	计算监控树的所有节点所需的最小摄像头数量。
	
//	贪心算法 从根部开始
//	0 代表该节点已经安装
//	1 代表该节点没有安装 且需要监视
//	2 代表该节点没有安装 但是被监视到了
	
	private int num;
    public int minCameraCover(TreeNode root) {
    	num = 0;
    	int temp = dfs(root);
    	return temp==1?num+1:num;
    }
    
    private int dfs(TreeNode root){
    	if(root==null) return 2;
    	int left = dfs(root.left);
    	int right = dfs(root.right);
    	if(left==1 || right==1){
    		num++;
    		return 0;
    	}
    	if(left == 0 || right==0)
    		return 2;

    	return 1;
    }
}

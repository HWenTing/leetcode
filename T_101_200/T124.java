package T_101_200;

public class T124 {

//	给定一个非空二叉树，返回其最大路径和。
//	本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
	
	int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    	sum(root);
        return max;
    }
    
    private int sum(TreeNode root){//返回左分支或者右分支或者带上根节点的最大值
        if(root == null) return 0;
        int left = Math.max(0, sum(root.left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, sum(root.right));
        max = Math.max(max, root.val + left + right); // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + root.val;
    }
}

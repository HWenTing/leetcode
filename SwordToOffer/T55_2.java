package SwordToOffer;


public class T55_2 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
//	输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//	同T110
	
	private boolean balance=true;
    public boolean isBalanced(TreeNode root) {
    	maxDepth(root);
        return balance;
    }
	    
	 private int maxDepth(TreeNode root) {
		if(root ==null || !balance)
			return 0;
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		if(Math.abs(l-r)>1)//判断条件
			balance=false;
		return Math.max(l, r)+1;
	 }
}

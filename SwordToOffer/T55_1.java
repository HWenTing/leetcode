package SwordToOffer;


public class T55_1 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
//	输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
	//同T104
	    public int maxDepth(TreeNode root) {
	    	if(root==null)
	    		return 0;
	    	return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
	    }
}

package SwordToOffer;


public class T27 {

//	请完成一个函数，输入一个二叉树，该函数输出它的镜像。

	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
//	递归
    public TreeNode mirrorTree(TreeNode root) {
    	if(root==null) return root;
    	TreeNode left = root.left;
    	root.left = mirrorTree(root.right);
    	root.right = mirrorTree(left);
    	return root;
    	
    }
}

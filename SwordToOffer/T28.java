package SwordToOffer;


public class T28 {

//	请实现一个函数，用来判断一棵二叉树是不是对称的。
	
	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	
	//先镜像一棵子树，然后看与另一半是否相等
    public boolean isSymmetric(TreeNode root) {
    	if(root==null) return true;
    	TreeNode left =  mirrorTree(root.left);
    	return isSame(left,root.right);
    }
    	
    private boolean isSame(TreeNode A,TreeNode B){
    	if(A==null && B==null) return true;
    	else if(A==null || B==null) return false;
    	
    	return A.val==B.val && isSame(A.left,B.left) && isSame(A.right,B.right);
    			
    }
    
    private TreeNode mirrorTree(TreeNode root) {
    	if(root==null) return root;
    	TreeNode left = root.left;
    	root.left = mirrorTree(root.right);
    	root.right = mirrorTree(left);
    	return root;
    }
    
    
//	还有一种思路是直接递归判断
//	isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
	
//    public boolean isSymmetric(TreeNode root) {
//    	if(root==null)
//    		return true;
//    	return isSymmetric(root.left,root.right);
//    }
//    
//    public boolean isSymmetric(TreeNode l,TreeNode r) {
//    	if(l==null && r==null)
//		return true;
//		if(l==null || r==null)
//			return false;
//		if(l.val!=r.val)
//			return false;
//		return isSymmetric(l.left,r.right) && isSymmetric(l.right,r.left);
//    }
}

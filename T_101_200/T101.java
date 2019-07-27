package T_101_200;

public class T101 {

//检查树是否镜像对称
//	第一想法是镜像翻转根节点右子树，与左子树对比看是否一样 
//	啊哈 一遍ac ，击败83%
//    public boolean isSymmetric(TreeNode root) {
//    	if(root==null)
//    		return true;
//    	
//    	mirror(root.right);
//    	return issame(root.left,root.right);
//    }
//    
//    private void mirror(TreeNode root){//镜像一棵树
//    	if(root==null)
//    		return ;
//    	TreeNode temp = root.left;
//    	root.left = root.right;
//    	root.right = temp;
//    	mirror(root.left);
//    	mirror(root.right);
//    	
//    }
//    
//    private boolean issame(TreeNode l,TreeNode r){//判断两棵树是否相等
//    	if(l==null && r==null)
//    		return true;
//    	if(l==null || r==null)
//    		return false;
//    	if(l.val!=r.val)
//    		return false;
//    	return issame(l.left,r.left) &&issame(l.right,r.right);
//    }
	
	
//	还有一种思路是直接递归判断
//	isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
	
    public boolean isSymmetric(TreeNode root) {
    	if(root==null)
    		return true;
    	return isSymmetric(root.left,root.right);
    }
    
    public boolean isSymmetric(TreeNode l,TreeNode r) {
    	if(l==null && r==null)
		return true;
		if(l==null || r==null)
			return false;
		if(l.val!=r.val)
			return false;
		return isSymmetric(l.left,r.right) && isSymmetric(l.right,r.left);
    }
    
    
}

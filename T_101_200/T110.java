package T_101_200;

public class T110 {

//	判断一颗树是不是平衡树
//	第一反应是 递归返回 isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left)-height(root.right))<=1;
//	但是感觉复杂度有点很高，因为有很多计算是重复的
//    public boolean isBalanced(TreeNode root) {
//        if(root==null)
//        	return true;
//        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1;
//    }
//    
////    求树的深度
//    private int maxDepth(TreeNode root) {
//    	if(root ==null)
//    		return 0;
//    	return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
//    }
	
//	第二种思路还是递归，不过简单了一些
//	维护一个balance全局变量
    
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

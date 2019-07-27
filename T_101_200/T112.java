package T_101_200;

public class T112 {

	
//	看是否存在一条路径和为sum
//	好吧这个题一开始理解错了，要从根节点到没有子节点的叶子节点（[1,2]，1  应该输出false）
//	这种做法满足只有左子树或右子树的情况
//    public boolean hasPathSum(TreeNode root, int sum) {
//    	if(root==null)
//    		return false;
//        return hp(root,sum);
//    }
//    
//    private boolean hp(TreeNode root, int sum){
//    	if(root==null)
//    		return sum==0;
//        return hp(root.left,sum-root.val)||hp(root.right,sum-root.val);
//    }
    
//	递归解决
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)
			return false;
		if(root.left==null && root.right==null && sum-root.val==0)//判断是否为叶子节点
			return true;
	    return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
  	}
	
}

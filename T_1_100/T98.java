package T_1_100;

public class T98 {
	
//	给定一个二叉树，判断其是否是一个有效的二叉搜索树。
	
//	快要恶心死了。。树太难了
	
//	中序遍历为有序数组
//	妈蛋，对边界值卡的太严了
	
	private int min;
	private boolean use=false;
	private boolean ans=true;
	public boolean isValidBST(TreeNode root) {
		if(!ans || root == null)
			return ans;
		isValidBST(root.left);
		if(!use){//对min进行赋值
			min=root.val;
			use=true;
		}else{
			if(min>=root.val)//判断是否递增
				ans=false;
			else
				min=root.val;
		}

		isValidBST(root.right);
		return ans;
	}
	
	
//	对边界值不是很严的话可以用下边的方法,模拟中序遍历依次判断是否递增
//	private int min = Integer.MIN_VALUE;
//	private boolean ans=true;
//	public boolean isValidBST(TreeNode root) {
//		if(!ans || root == null)
//			return ans;
//		isValidBST(root.left);
//		if(min>=root.val)
//			ans=false;
//		else
//			min=root.val;
//		isValidBST(root.right);
//		return ans;
//	}
	
}






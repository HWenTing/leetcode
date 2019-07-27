package T_401_500;


class TreeNode {
    int val;     
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class T437 {

//	找到路径和为sum的路径个数
	
//	下边一开始的实现错了，出现了多次调用的情况，不好处理
//	下边是改好的版本
	private int ans=0;
	public int pathSum(TreeNode root, int sum) {
		if(root==null)
			return 0;
		pathSum1(root,sum);
		pathSum(root.left,sum);
		pathSum(root.right,sum);
		return ans;
	}
	 
    public void pathSum1(TreeNode root, int sum) {
    	if(root==null)
    		return;
    	if(sum==root.val){
    		ans++;
    	}
    	pathSum1(root.left,sum-root.val);
    	pathSum1(root.right,sum-root.val);
    }
	
	
	
//	递归 
//	确保在每个节点，pathSum(root,sum)只调用一次，以免出现上边的错误
//	public int pathSum(TreeNode root, int sum) {
//		if(root == null)
//			return 0;
//		return subpathSum(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);//确保在每个节点，pathSum(root,sum)只调用一次
//	}
//	
//	private int subpathSum(TreeNode root, int sum){
//		if(root == null)
//			return 0;
//		int ans=0;
//		if(root.val==sum)
//			ans++;
//		ans += subpathSum(root.left,sum-root.val)+subpathSum(root.right,sum-root.val);
//		return ans;
//	}
//	
	
	
	
	
	
	
	
	
}

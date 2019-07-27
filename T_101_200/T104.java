package T_101_200;
class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class T104 {

//	求树的最大高度 
//	直接递归 左子树右子树较大值+1
    public int maxDepth(TreeNode root) {
    	if(root ==null)
    		return 0;
    	return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}

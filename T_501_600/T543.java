package T_501_600;


class TreeNode {
    int val;     
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class T543 {
	
//	第一次做，似乎递归的有点麻烦。。。击败17%
//	递归咯，
//	public static int diameterOfBinaryTree(TreeNode root) {
//		if(root!=null){
//			return Math.max(dis(root.left)+dis(root.right), Math.max(diameterOfBinaryTree(root.right),diameterOfBinaryTree(root.left)));			
//		}
//		return 0;
//    }
//	public static int dis(TreeNode root){
//		if(root!=null){
//			return Math.max(dis(root.left)+1, dis(root.right)+1);			
//		}
//		return 0;
//	}
	
	
//	改进递归方式，类似T110，增加全局变量 击败82%
	
	private int max=0;
	public  int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return max;
	}
	
    public int maxDepth(TreeNode root) {
    	if(root ==null)
    		return 0;
    	
    	int l = maxDepth(root.left);
    	int r = maxDepth(root.right);
    	if(l+r>max)
    		max = l+r;
    	return Math.max(l, r)+1;
    }
}

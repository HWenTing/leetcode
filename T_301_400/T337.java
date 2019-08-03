package T_301_400;

class TreeNode {
    int val;     
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class T337 {
	
//  最高金额在root（四个孙子节点）和两子节点和之间取
//但是速度慢的不行
  
	public int rob(TreeNode root) {
		if (root == null) return 0;
		int val1 = root.val;
	    if (root.left != null) val1 += rob(root.left.left) +            rob(root.left.right);
	    if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
	    int val2 = rob(root.left) + rob(root.right);
	    return Math.max(val1, val2);
	}   
}

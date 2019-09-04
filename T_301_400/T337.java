package T_301_400;

import java.util.HashMap;

class TreeNode {
    int val;     
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class T337 {	
	
//  最高金额在root（四个孙子节点）和两子节点和之间取
//但是速度慢的不行，重复计算了很多数
//  可以加个hashmap存储计算过的值，快了100倍。。。
	
	HashMap<TreeNode,Integer> map = new HashMap<>();
	public int rob(TreeNode root) {
		if (root == null) return 0;
		if(map.containsKey(root)) return map.get(root);
		int val1 = root.val;
	    if (root.left != null) val1 += rob(root.left.left) +            rob(root.left.right);
	    if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
	    int val2 = rob(root.left) + rob(root.right);
	    int max = Math.max(val1, val2);
	    map.put(root, max);
	    return max;
	}   
}

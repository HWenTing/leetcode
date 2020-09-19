package T_301_400;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;     
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class T337 {	
	
//	在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
//	这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
//	一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 
//	如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//	计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

	
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
	
	
//	思路差不多，只不过分了两个map 
//	f(o) 表示选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和；g(o) 表示不选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和；l 和 r代表 o 的左右孩子。

//    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
//    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();
//    public int rob(TreeNode root) {
//        dfs(root);
//        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
//    }
//    public void dfs(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        dfs(node.left);
//        dfs(node.right);
//        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
//        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
//    }


}

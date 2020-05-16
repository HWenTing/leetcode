package SwordToOffer;

import java.util.LinkedList;
import java.util.List;

public class T34 {

	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
//	输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//	和T113相同 递归
	
	private List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	ans = new LinkedList<>();
    	if(root==null) return ans;
    	subPathSum(root,sum,new LinkedList<>());
    	return ans;
    }
    
    private void subPathSum(TreeNode root, int sum,List<Integer> cur){
    	
    	cur.add(root.val);
    	if(root.left==null && root.right==null &&root.val==sum){//到达叶子节点且符合条件
    		ans.add(new LinkedList<>(cur));
    	}
    	
    	if(root.left!=null) subPathSum(root.left,sum-root.val,cur);//左子树
    	if(root.right!=null) subPathSum(root.right,sum-root.val,cur);//右子树
    	cur.remove(cur.size()-1);//恢复现场
    }
    
}

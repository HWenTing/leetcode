package SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

public class T32_1 {

//	从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

	 
	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	 
//	 层序遍历
    public int[] levelOrder(TreeNode root) {
    	if(root==null) return new int[0];
    	LinkedList<Integer> ans = new LinkedList<>(); 
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while(!queue.isEmpty()){
    		TreeNode cur = queue.poll();
    		ans.add(cur.val);
    		if(cur.left!=null) queue.add(cur.left);
    		if(cur.right!=null) queue.add(cur.right);
    	}
    	
    	return ans.stream().mapToInt(i -> i).toArray();//list转化为int数组
    	
    }
    
}

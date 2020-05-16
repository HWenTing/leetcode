package SwordToOffer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class T32_2 {

//	从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	if(root==null)
    		return new LinkedList<>();
    	List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int len = queue.size();
        	List<Integer> temp= new LinkedList<>();
        	for(int i=0;i<len;i++){
        		TreeNode cur = queue.poll();
        		temp.add(cur.val);
        		if(cur.left!=null) queue.add(cur.left);
        		if(cur.right!=null) queue.add(cur.right);
        	}
        	ans.add(temp);
        }
        return ans;
    }
    
}
